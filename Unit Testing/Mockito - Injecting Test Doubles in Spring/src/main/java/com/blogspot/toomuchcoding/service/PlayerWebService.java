package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.model.Player;

/**
 * User: mgrzejszczak
 * Date: 08.08.13
 * Time: 14:47
 */
public interface PlayerWebService {
    String getWebServiceName();
    Player getPlayerByName(String name);
}
