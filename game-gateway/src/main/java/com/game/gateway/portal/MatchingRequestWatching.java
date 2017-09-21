package com.game.gateway.portal;

import akka.actor.Props;
import com.framework.message.ApiRequestLogin;
import com.framework.message.ApiRequest;
import com.framework.message.BusinessMessage;
import com.framework.message.ResponseMessage;
import com.framework.message.ResponseMessageDomain;
import com.framework.niosocket.*;
import com.framework.niosocket.akka.ActorRequestWatching;
import com.framework.niosocket.RequestController;
import com.framework.niosocket.akka.ActorRequestRemoteProxyWatching;
import com.game.gateway.AkkaRemoteActorEntity;
import com.game.gateway.MessageProvider;
import com.game.gateway.proto.DOMAIN;
import com.game.gateway.proto.ERROR_CODE;
import com.game.gateway.proto.GATEWAY_APIS;

import javax.annotation.Resource;

/**
 * Created by @panyao on 2017/8/25.
 */
@RequestController(apiPathCode = GATEWAY_APIS.MATCHING_V1_0_0_VALUE)
public class MatchingRequestWatching implements ActorRequestWatching {

    @Resource
    private AkkaRemoteActorEntity akkaRemoteActorEntity;

    @Override
    public Props getProps(ChannelOutputHandler outputHandler) {
        return ActorRequestRemoteProxyWatching.props(
                MatchingRemoteProxyRouterActorRequestRequestRemoteProxy.class,
                DOMAIN.MATCHING_VALUE,
                akkaRemoteActorEntity.getMatchingRequestPath(),
                outputHandler
        );
    }

    private static class MatchingRemoteProxyRouterActorRequestRequestRemoteProxy extends ActorRequestRemoteProxyWatching {

        public MatchingRemoteProxyRouterActorRequestRequestRemoteProxy(int domain, String remotePath, ChannelOutputHandler context) {
            super(domain, remotePath, context);
        }

        @Override
        public void onRequest(ApiRequest request) {
            long userId = ContextAdapter.getLoginUserId(context.getRawContext().channel().id());
            if (userId <= 0) {
                ResponseMessage message = ResponseMessage.newMessage(request.getApiOpcode(),
                        MessageProvider.produceMessage(BusinessMessage.error(ERROR_CODE.MATCHING_API_UNAUTHORIZED)));

                ResponseMessageDomain messageDomain = ResponseMessageDomain.newResponseMessageDomain(DOMAIN.MATCHING_VALUE, message);

                // 回复消息到 gateway domain
                getSelf().tell(messageDomain, getSelf());
                return;
            }
            getSelf().tell(ApiRequestLogin.newClientApiRequestWithActor(userId, request.getApiOpcode(), request.getVersion(), request.getArgs()), getSelf());
        }

    }

}