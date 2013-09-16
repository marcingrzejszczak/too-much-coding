package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * User: mgrzejszczak
 * Date: 08.08.13
 * Time: 14:48
 */
@Service
public class PlayerWebServiceImpl implements PlayerWebService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerWebServiceImpl.class);
    public static final String WEB_SERVICE_NAME = "SuperPlayerWebService";
    public static final String SAMPLE_PLAYER_VALUE = "1000";

    @Override
    public String getWebServiceName() {
        return WEB_SERVICE_NAME;
    }

    @Override
    public Player getPlayerByName(String name) {
        try {
            LOGGER.debug("Simulating awaiting time for a response from a web service");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOGGER.error(String.format("[%s] occurred while trying to make the thread sleep", e));
        }
        return new Player(name, new BigDecimal(SAMPLE_PLAYER_VALUE));
    }
}
