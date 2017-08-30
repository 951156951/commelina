package com.module.foundation.game.gateway.portal;


import akka.actor.Props;
import com.google.common.base.Splitter;
import com.google.common.io.BaseEncoding;
import com.module.foundation.game.gateway.MessageProvider;
import com.module.foundation.game.gateway.proto.DOMAIN_CONSTANTS;
import com.module.foundation.game.gateway.proto.ERROR_CODE_CONSTANTS;
import com.module.foundation.game.gateway.proto.GATEWAY_APIS;
import com.nexus.maven.core.message.ApiRouterRequest;
import com.nexus.maven.core.message.BusinessMessage;
import com.nexus.maven.core.message.RequestArg;
import com.nexus.maven.core.message.ResponseMessage;
import com.nexus.maven.netty.socket.*;

import java.util.List;

/**
 * Created by @panyao on 2017/8/25.
 */
@ActorWithApiController(apiPathCode = GATEWAY_APIS.GATEWAY_V1_0_0_VALUE)
public class GatewayRouterActor implements ActorWithApiHandler {

    @Override
    public Props getProps(ChannelOutputHandler outputHandler) {
        return GatewayActor.props(GatewayActor.class, DOMAIN_CONSTANTS.GATE_WAY_VALUE, outputHandler);
    }

    private static class GatewayActor extends ActorWithRequestRouter {

        public GatewayActor(int domain, ChannelOutputHandler context) {
            super(domain, context);
        }

        @Override
        public boolean onRequest(ApiRouterRequest request) {
            switch (request.getApiOpcode().getNumber()) {
                case 0:
                    RequestArg tokenArg = request.getArg(0);
                    if (tokenArg == null) {
                        // token 转换错误
                        getSelf().tell(ResponseMessage.newMessage(request.getApiOpcode(),
                                MessageProvider.produceMessage(BusinessMessage.error(ERROR_CODE_CONSTANTS.TOKEN_PARSE_ERROR))
                        ), getSelf());
                    }
                    String token = tokenArg.getAsString();
                    String parseToken = new String(BaseEncoding.base64Url().decode(token));
                    List<String> tokenChars = Splitter.on('|').splitToList(parseToken);
                    ContextAdapter.userLogin(context.getRawContext().channel().id(), Long.valueOf(tokenChars.get(0)));

                    // FIXME: 2017/8/30 登陆成功，返回用户状态，如果是 in game 就走重连机制
                    // 回复自己完成了操作
                    getSelf().tell(ResponseMessage.newMessage(request.getApiOpcode(), MessageProvider.produceMessage()), getSender());
                    return true;
            }
            return false;
        }
    }


}
