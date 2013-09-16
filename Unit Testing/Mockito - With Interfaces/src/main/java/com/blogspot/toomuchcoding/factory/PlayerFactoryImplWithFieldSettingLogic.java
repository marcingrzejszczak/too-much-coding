package com.blogspot.toomuchcoding.factory;

import com.blogspot.toomuchcoding.adapter.CommonPlayerAdapter;
import com.blogspot.toomuchcoding.adapter.DefencePlayerAdapter;
import com.blogspot.toomuchcoding.adapter.OffensivePlayerAdapter;
import com.blogspot.toomuchcoding.model.*;

/**
 * User: mgrzejszczak
 * Date: 09.06.13
 * Time: 15:53
 */

public class PlayerFactoryImplWithFieldSettingLogic implements PlayerFactory {

    @Override
    public Player createPlayer(PositionType positionType) {
        PlayerDetails player = createCommonPlayer(positionType);
        switch (positionType){
            case ATT:
                return createOffensivePlayer(player);
            case MID:
                return createOffensivePlayer(player);
            case DEF:
                return createDefensivePlayer(player);
            case GK:
                return createDefensivePlayer(player);
            default:
                return new CommonPlayerAdapter(player);
        }
    }

    private Player createDefensivePlayer(PlayerDetails player) {
        DefencePlayerAdapter defencePlayerAdapter = new DefencePlayerAdapter(player);
        defencePlayerAdapter.defend();
        defencePlayerAdapter.playSomeMusic();
        defencePlayerAdapter.doSomeSeriousCoding();
        return defencePlayerAdapter;
    }

    private OffensivePlayer createOffensivePlayer(PlayerDetails player) {
        OffensivePlayer offensivePlayer = new OffensivePlayerAdapter(player);
        offensivePlayer.shoot();
        return offensivePlayer;
    }

    private PlayerDetails createCommonPlayer(PositionType positionType){
        PlayerDetails playerDetails = new PlayerDetails();
        playerDetails.setPosition(positionType);
        return playerDetails;
    }
}
