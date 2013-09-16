package com.blogspot.toomuchcoding.factory;

import com.blogspot.toomuchcoding.model.Player;
import com.blogspot.toomuchcoding.model.PositionType;

/**
 * User: mgrzejszczak
 * Date: 28.05.13
 * Time: 23:16
 */
public interface PlayerFactory {
    Player createPlayer(PositionType positionType);
}
