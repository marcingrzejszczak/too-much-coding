package com.blogspot.toomuchcoding.adapter;

import com.blogspot.toomuchcoding.model.OffensivePlayer;
import com.blogspot.toomuchcoding.model.PlayerDetails;

/**
 * User: mgrzejszczak
 * Date: 09.06.13
 * Time: 15:42
 */
public class OffensivePlayerAdapter extends CommonPlayerAdapter implements OffensivePlayer {

    public OffensivePlayerAdapter(PlayerDetails playerDetails){
        super(playerDetails);
    }

    @Override
    public void shoot(){
        System.out.printf("%s Shooooot!.%n", getPlayerDetails().getName());
    }
}
