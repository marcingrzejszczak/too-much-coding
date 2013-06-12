package com.blogspot.toomuchcoding.adapter;

import com.blogspot.toomuchcoding.model.Player;
import com.blogspot.toomuchcoding.model.PlayerDetails;

/**
 * User: mgrzejszczak
 * Date: 09.06.13
 * Time: 15:42
 */
public class CommonPlayerAdapter implements Player {
    private final PlayerDetails playerDetails;

    public CommonPlayerAdapter(PlayerDetails playerDetails){
        this.playerDetails = playerDetails;
    }

    @Override
    public void run() {
        System.out.printf("Run %s. Run!%n", playerDetails.getName());
    }

    public PlayerDetails getPlayerDetails() {
        return playerDetails;
    }
}
