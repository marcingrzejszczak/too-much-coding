package com.blogspot.toomuchcoding.model;

import java.math.BigDecimal;

/**
 * User: mgrzejszczak
 * Date: 08.08.13
 * Time: 14:38
 */
public final class Player {
    private final String playerName;
    private final BigDecimal playerValue;

    public Player(final String playerName, final BigDecimal playerValue) {
        this.playerName = playerName;
        this.playerValue = playerValue;
    }

    public String getPlayerName() {
        return playerName;
    }

    public BigDecimal getPlayerValue() {
        return playerValue;
    }
}
