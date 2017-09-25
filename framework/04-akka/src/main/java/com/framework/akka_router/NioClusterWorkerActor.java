package com.framework.akka_router;

import akka.dispatch.OnFailure;
import akka.dispatch.OnSuccess;
import com.framework.message.ApiRequest;
import com.framework.message.ResponseMessage;
import com.framework.niosocket.ReplyUtils;
import com.framework.niosocket.proto.SERVER_CODE;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.concurrent.Future;

/**
 * Created by @panyao on 2017/9/25.
 */
public abstract class NioClusterWorkerActor implements ActorRequestHandler {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onRequest(ApiRequest request, ChannelHandlerContext ctx) {
        // 转发到业务 actor 上去
        Future<Object> future = AkkaWorkerSystem.Holder.AKKA_WORKER_SYSTEM.routerAsk(new ClusterRouterJoinEntity(this.getDomain(), (byte) 0, request));

        // actor 处理成功
        future.onSuccess(new OnSuccess<Object>() {
            @Override
            public void onSuccess(Object result) throws Throwable {
                ReplyUtils.reply(ctx, getDomain(), ResponseMessage.newMessage(request.getApiOpcode(), ((RouterResponseEntity) result).getMessage()));
            }
        }, AkkaWorkerSystem.Holder.AKKA_WORKER_SYSTEM.system.dispatcher());

        future.onFailure(new OnFailure() {
            @Override
            public void onFailure(Throwable failure) throws Throwable {
                ReplyUtils.reply(ctx, SERVER_CODE.SERVER_ERROR);
                logger.error("actor return error.{}", failure);
            }
        }, AkkaWorkerSystem.Holder.AKKA_WORKER_SYSTEM.system.dispatcher());
    }

}
