package com.game.matching.service;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.game.matching.OpCodeConstants;
import com.game.matching.portal.MatchingGroup;
import com.nexus.maven.akka.AkkaBroadcast;
import com.nexus.maven.core.message.BroadcastResponse;
import com.nexus.maven.core.message.JsonMessage;

/**
 * Created by @panyao on 2017/8/14.
 * <p>
 * 同步匹配状态dao到客户端
 */
public class MatchingStatus extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(NOTIFY_MATCH_STATUS.class, ms -> {
                    BroadcastResponse broadcast = AkkaBroadcast.newBroadcast(ms.userIds,
                            JsonMessage.newHandlerJSONKV(OpCodeConstants.NOTIFY_MATCH_SUCCESS, "matchUserCount", ms.userIds.length));
                    // FIXME: 2017/8/15 如何确保消息正确送达了呢？
                    getContext().system().actorSelection(MatchingGroup.GOURP_PATH).tell(broadcast, getSelf());
                })
                .match(Matching.CREATE_ROOM_FAILED_TRY_SUCCESS.class, s -> getContext().stop(getSelf()))
                .build();
    }

    public static final class NOTIFY_MATCH_STATUS {
        long[] userIds;

        public NOTIFY_MATCH_STATUS(long[] userIds) {
            this.userIds = userIds;
        }
    }

    public static Props props() {
        return Props.create(MatchingStatus.class);
    }

}
