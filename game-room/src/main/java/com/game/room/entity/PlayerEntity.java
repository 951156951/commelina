package com.game.room.entity;

/**
 * Created by @panyao on 2017/9/6.
 */
public class PlayerEntity {
    private long userId;

    private PlayerStatus playerStatus;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

}
