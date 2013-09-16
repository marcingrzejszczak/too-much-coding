package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.model.Player;

/**
 * User: mgrzejszczak
 * Date: 08.06.13
 * Time: 18:59
 */
public interface PlayerService {
    Player getPlayerByName(String playerName);
}
