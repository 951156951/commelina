package com.commelina.math24.play.robot.interfaces;

import com.github.freedompy.commelina.niosocket.proto.SocketASK;

/**
 *
 * @author @panyao
 * @date 2017/9/11
 */
public interface HandlerEvent {

    SocketASK handler(MemberEventLoop eventLoop);

}