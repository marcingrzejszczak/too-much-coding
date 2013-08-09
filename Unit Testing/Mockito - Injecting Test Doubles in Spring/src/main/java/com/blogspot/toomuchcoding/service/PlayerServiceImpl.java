package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: mgrzejszczak
 * Date: 08.06.13
 * Time: 19:02
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);

    @Autowired
    private PlayerWebService playerWebService;

    @Override
    public Player getPlayerByName(String playerName) {
        LOGGER.debug(String.format("Logging the player web service name [%s]", playerWebService.getWebServiceName()));
        return playerWebService.getPlayerByName(playerName);
    }

    public PlayerWebService getPlayerWebService() {
        return playerWebService;
    }

    public void setPlayerWebService(PlayerWebService playerWebService) {
        this.playerWebService = playerWebService;
    }
}
