package com.business.game.gateway.service;

import com.github.freedompy.commelina.akka.dispatching.ActorServiceHandler;
import com.github.freedompy.commelina.akka.dispatching.LocalServiceHandler;
import com.github.freedompy.commelina.akka.dispatching.LoginUserEntity;
import com.github.freedompy.commelina.akka.dispatching.cluster.AkkaMultiWorkerSystem;
import com.github.freedompy.commelina.akka.dispatching.cluster.AkkaMultiWorkerSystemContext;
import com.github.freedompy.commelina.akka.dispatching.local.AbstractLocalServiceActor;
import com.github.freedompy.commelina.akka.dispatching.local.AkkaLocalWorkerSystem;
import com.github.freedompy.commelina.akka.dispatching.proto.ApiRequest;
import com.github.freedompy.commelina.akka.dispatching.proto.MemberOnlineEvent;
import com.github.freedompy.commelina.core.BusinessMessage;
import com.github.freedompy.commelina.core.DefaultMessageProvider;
import com.game.gateway.proto.*;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;

/**
 * @author @panyao
 * @date 2017/9/25
 */
@ActorServiceHandler
public class SessionImpl implements LocalServiceHandler {

    @Override
    public Internal.EnumLite getRouterId() {
        return GATEWAY_METHODS.PASSPORT_CONNECT;
    }

    @Override
    public Class<SessionActorLocal> getPropsClass() {
        return SessionActorLocal.class;
    }

    private static final class SessionActorLocal extends AbstractLocalServiceActor {

        public SessionActorLocal(Internal.EnumLite routerId) {
            super(routerId);
        }

        @Override
        public void onRequest(ApiRequest request) {
            ByteString tokenArg = request.getArgs(0);
            if (tokenArg == null) {
                // token 转换错误
                response(DefaultMessageProvider.produceMessage(BusinessMessage.error(ERROR_CODE.TOKEN_PARSE_ERROR)));
                return;
            }

//        String token = tokenArg.getAsString();
//        String parseToken = new String(BaseEncoding.base64Url().decode(token));
//        List<String> tokenChars = Splitter.on('|').splitToList(parseToken);
//        ContextAdapter.userLogin(context.getRawContext().channel().id(), Long.valueOf(tokenChars.get(0)));
//        ContextAdapter.userLogin(context.channel().id(), tokenArg.getAsLong());
            long userId = Long.valueOf(tokenArg.toStringUtf8());
            getLogger().info("userId:{}, 登录成功", userId);
            getSender().tell(new LoginUserEntity(userId, DefaultMessageProvider.produceMessage()), getSelf());

            // 获取用户最后访问的 domain
            FindLastAccessDomainResponse domain = (FindLastAccessDomainResponse) AkkaLocalWorkerSystem.INSTANCE.askLocalRouterNode(
                    FindLastAccessDomainRequest.newBuilder()
                            .setUserId(userId)
                            .build()
            );

            if (domain != null) {
                AkkaMultiWorkerSystem clusterSystem = AkkaMultiWorkerSystemContext.INSTANCE.getContext(domain.getDomainValue());
                if (clusterSystem != null) {
                    // 向远程发送下线通知
                    clusterSystem.askRouterClusterNode(MemberOnlineEvent.newBuilder().setLoginUserId(userId).build());
                }
            }

            // 重置访问的 domain
            AkkaLocalWorkerSystem.INSTANCE.askLocalRouterNode(
                    ResetAccesssDoamin.newBuilder()
                            .setUserId(userId)
                            .build()
            );

        }
    }
}