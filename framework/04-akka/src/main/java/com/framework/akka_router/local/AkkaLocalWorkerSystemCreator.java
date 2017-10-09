package com.framework.akka_router.local;

import akka.actor.Props;
import com.framework.akka_router.ServiceHandler;

import java.util.Map;

/**
 * Created by @panyao on 2017/9/30.
 */
public final class AkkaLocalWorkerSystemCreator {

    public void registerRouter(Class<? extends RouterFrontendLocalActor> localActorClass, Map<String, ServiceHandler> routers) {
        AkkaLocalWorkerSystem.INSTANCE.registerRouterFronted(Props.create(localActorClass));
        for (ServiceHandler handler : routers.values()) {
            AkkaLocalWorkerSystem.INSTANCE.getSystem().actorOf(Props.create(handler.getPropsClass(), handler.getRouterId()));
        }
    }

    public void registerRouter(Map<String, ServiceHandler> routers) {
        registerRouter(RouterFrontendLocalActor.class, routers);
    }

    public static AkkaLocalWorkerSystemCreator create(String akkaActorConfig) {
        AkkaLocalWorkerSystem.INSTANCE.create(akkaActorConfig);
        return new AkkaLocalWorkerSystemCreator();
    }

    public static AkkaLocalWorkerSystemCreator create() {
        AkkaLocalWorkerSystem.INSTANCE.create();
        return new AkkaLocalWorkerSystemCreator();
    }

    private AkkaLocalWorkerSystemCreator() {

    }

}