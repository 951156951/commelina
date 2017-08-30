package com.nexus.maven.core.message;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Created by @panyao on 2017/8/16.
 */
public class DefaultJsonMessageProvider {

    private static final BusinessMessage EMPTY_RESPONSE_MESSAGE =
            BusinessMessage.success();

    public static MessageBus newMessage() {
        return new JsonMessage(EMPTY_RESPONSE_MESSAGE);
    }

    public static MessageBus newMessage(BusinessMessage message) {
        Preconditions.checkNotNull(message);
        return new JsonMessage(message);
    }

    public static MessageBus newMessageForKV(String k, Object v) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(k));
        Preconditions.checkNotNull(v);
        KVEntity entity = new KVEntity();
        entity.k = k;
        entity.v = v;
        return new JsonMessage(BusinessMessage.success(entity));
    }

    public static final class KVEntity {
        String k;
        Object v;
    }
}
