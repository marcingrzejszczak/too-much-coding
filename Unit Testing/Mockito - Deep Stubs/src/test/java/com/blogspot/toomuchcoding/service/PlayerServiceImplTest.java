package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.model.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: mgrzejszczak
 * Date: 08.06.13
 * Time: 19:26
 */
public class PlayerServiceImplTest {

    public static final String COUNTRY_CODE_ENG = "ENG";
    PlayerServiceImpl objectUnderTest = new PlayerServiceImpl();

    @Test
    public void shouldReturnTrueIfCountryCodeIsTheSame() throws Exception {
        //given
        PlayerDetails playerDetails = new PlayerDetails();
        ClubDetails clubDetails = new ClubDetails();
        CountryDetails countryDetails = new CountryDetails();
        CountryCodeDetails countryCodeDetails = new CountryCodeDetails();
        playerDetails.setClubDetails(clubDetails);
        clubDetails.setCountry(countryDetails);
        countryDetails.setCountryCode(countryCodeDetails);
        countryCodeDetails.setCountryCode(CountryCodeType.ENG);

        //when
        boolean playerOfGivenCountry = objectUnderTest.isPlayerOfGivenCountry(playerDetails, COUNTRY_CODE_ENG);

        //then
        assertThat(playerOfGivenCountry, is(true));
    }

    @Test
    public void shouldReturnTrueIfCountryCodeIsTheSameUsingMockitoReturnDeepStubs() throws Exception {
        //given
        PlayerDetails playerDetailsMock = mock(PlayerDetails.class, RETURNS_DEEP_STUBS);
        CountryCodeType countryCodeType = CountryCodeType.ENG;
        when(playerDetailsMock.getClubDetails().getCountry().getCountryCode().getCountryCode()).thenReturn(countryCodeType);

        //when
        boolean playerOfGivenCountry = objectUnderTest.isPlayerOfGivenCountry(playerDetailsMock, COUNTRY_CODE_ENG);

        //then
        assertThat(playerOfGivenCountry, is(true));
    }
}
