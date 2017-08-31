package com.framework.netty_socket;

import com.framework.proto.SocketASK;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by @panyao on 2017/8/28.
 */
public interface RouterContext {

    void doRequestHandler(ChannelHandlerContext ctx, SocketASK socketASK);

    void onlineEvent(ChannelHandlerContext ctx);

    void offlineEvent(long logoutUserId, ChannelHandlerContext ctx);

    void exceptionEvent(ChannelHandlerContext ctx, Throwable cause);

}