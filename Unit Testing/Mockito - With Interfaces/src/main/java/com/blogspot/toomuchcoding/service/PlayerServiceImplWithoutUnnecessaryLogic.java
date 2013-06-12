package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.factory.PlayerFactory;
import com.blogspot.toomuchcoding.model.*;

/**
 * User: mgrzejszczak
 * Date: 08.06.13
 * Time: 19:02
 */
public class PlayerServiceImplWithoutUnnecessaryLogic implements PlayerService {

    private PlayerFactory playerFactory;

    /**
     * What's the point in having this method then?
     * @param positionType
     * @return
     */
    @Override
    public Player playAGameWithAPlayerOfPosition(PositionType positionType) {
        return playerFactory.createPlayer(positionType);
    }

    public PlayerFactory getPlayerFactory() {
        return playerFactory;
    }

    public void setPlayerFactory(PlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }
}
