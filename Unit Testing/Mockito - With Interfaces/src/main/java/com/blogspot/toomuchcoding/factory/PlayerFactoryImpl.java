package com.blogspot.toomuchcoding.factory;

import com.blogspot.toomuchcoding.adapter.CommonPlayerAdapter;
import com.blogspot.toomuchcoding.adapter.DefencePlayerAdapter;
import com.blogspot.toomuchcoding.adapter.OffensivePlayerAdapter;
import com.blogspot.toomuchcoding.model.Player;
import com.blogspot.toomuchcoding.model.PlayerDetails;
import com.blogspot.toomuchcoding.model.PositionType;

/**
 * User: mgrzejszczak
 * Date: 09.06.13
 * Time: 15:53
 */

public class PlayerFactoryImpl implements PlayerFactory {

    @Override
    public Player createPlayer(PositionType positionType) {
        PlayerDetails player = createCommonPlayer(positionType);
        switch (positionType){
            case ATT:
                return new OffensivePlayerAdapter(player);
            case MID:
                return new OffensivePlayerAdapter(player);
            case DEF:
                return new DefencePlayerAdapter(player);
            case GK:
                return new DefencePlayerAdapter(player);
            default:
                return new CommonPlayerAdapter(player);
        }
    }

    private PlayerDetails createCommonPlayer(PositionType positionType){
        PlayerDetails playerDetails = new PlayerDetails();
        playerDetails.setPosition(positionType);
        return playerDetails;
    }
}
