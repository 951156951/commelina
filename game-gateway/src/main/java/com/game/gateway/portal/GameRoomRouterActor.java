package com.game.gateway.portal;

import akka.actor.Props;
import com.framework.akka.ApiRequestWithActor;
import com.framework.message.*;
import com.framework.niosocket.*;
import com.game.gateway.AkkaRemoteActorEntity;
import com.game.gateway.MessageProvider;
import com.game.gateway.proto.DOMAIN_CONSTANTS;
import com.game.gateway.proto.ERROR_CODE_CONSTANTS;

import javax.annotation.Resource;

/**
 * Created by @panyao on 2017/8/25.
 */
@ActorWithApiController(apiPathCode = com.game.gateway.proto.GATEWAY_APIS.GAME_ROOM_V1_0_0_VALUE)
public class GameRoomRouterActor implements ActorWithApiHandler {

    @Resource
    private AkkaRemoteActorEntity akkaRemoteActorEntity;

    @Override
    public Props getProps(ChannelOutputHandler outputHandler) {
        return ActorWithRemoteProxyRouter.props(
                RoomRemoteProxyRouterActor.class,
                DOMAIN_CONSTANTS.GAME_ROOM_VALUE,
                akkaRemoteActorEntity.getRoomPath(),
                outputHandler
        );
    }
    // DOMAIN_CONSTANTS.GAME_ROOM_VALUE


    private static class RoomRemoteProxyRouterActor extends ActorWithRemoteProxyRouter {

        public RoomRemoteProxyRouterActor(int domain, String remotePath, ChannelOutputHandler context) {
            super(domain, remotePath, context);
        }

        @Override
        public void onRequest(ApiRouterRequest request) {
            long userId = ContextAdapter.getLoginUserId(context.getRawContext().channel().id());
            if (userId <= 0) {
                // 不登录,直接告诉客户端错误
                ResponseMessage message = ResponseMessage.newMessage(request.getApiOpcode(),
                        MessageProvider.produceMessage(BusinessMessage.error(ERROR_CODE_CONSTANTS.ROOM_API_UNAUTHORIZED)));

                ResponseMessageDomain messageDomain = ResponseMessageDomain.newResponseMessageDomain(DOMAIN_CONSTANTS.MATCHING_VALUE, message);

                // 回复消息到 gateway domain
                getSelf().tell(messageDomain, getSelf());
                return;
            }

            RequestArg roomId = request.getArg(0);
            if (roomId == null || roomId.getAsLong() <= 0) {
                // 第一个参数必须是 room Id
                ResponseMessage message = ResponseMessage.newMessage(request.getApiOpcode(),
                        MessageProvider.produceMessage(BusinessMessage.error(ERROR_CODE_CONSTANTS.ROOM_API_IMPORT_ROOM_ID))
                );

                ResponseMessageDomain messageDomain = ResponseMessageDomain.newResponseMessageDomain(DOMAIN_CONSTANTS.MATCHING_VALUE, message);

                // 回复消息到 gateway domain
                getSelf().tell(messageDomain, getSelf());
                return;
            }

            getSelf().tell(ApiRequestWithActor.newApiRequestWithActor(userId, request.getApiOpcode(), request.getVersion(), request.getArgs()), getSelf());
        }

    }
}
