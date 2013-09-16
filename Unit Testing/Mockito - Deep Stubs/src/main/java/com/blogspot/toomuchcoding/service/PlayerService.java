package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.model.PlayerDetails;

/**
 * User: mgrzejszczak
 * Date: 08.06.13
 * Time: 18:59
 */
public interface PlayerService {
    boolean isPlayerOfGivenCountry(PlayerDetails playerDetails, String country);
}
