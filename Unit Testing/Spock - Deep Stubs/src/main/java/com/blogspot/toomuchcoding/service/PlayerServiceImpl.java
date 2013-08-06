package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.model.PlayerDetails;

/**
 * User: mgrzejszczak
 * Date: 08.06.13
 * Time: 19:02
 */
public class PlayerServiceImpl implements PlayerService {
    @Override
    public boolean isPlayerOfGivenCountry(PlayerDetails playerDetails, String country) {
        String countryValue = playerDetails.getClubDetails().getCountry().getCountryCode().getCountryCode().value();
        return countryValue.equalsIgnoreCase(country);
    }
}
