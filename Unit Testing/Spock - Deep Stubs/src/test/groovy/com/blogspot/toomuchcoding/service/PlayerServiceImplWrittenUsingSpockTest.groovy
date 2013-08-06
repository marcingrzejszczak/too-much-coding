package com.blogspot.toomuchcoding.service

import com.blogspot.toomuchcoding.model.*
import com.blogspot.toomuchcoding.spock.ExtendedSpockSpecification

/**
 * User: mgrzejszczak
 * Date: 14.06.13
 * Time: 16:06
 */
class PlayerServiceImplWrittenUsingSpockTest extends ExtendedSpockSpecification {

    public static final String COUNTRY_CODE_ENG = "ENG";

    PlayerServiceImpl objectUnderTest

    def setup(){
        objectUnderTest = new PlayerServiceImpl()
    }

    def "should return true if country code is the same when creating nested structures using groovy"() {
        given:
            PlayerDetails playerDetails = new PlayerDetails(
                    clubDetails: new ClubDetails(
                            country: new CountryDetails(
                                    countryCode: new CountryCodeDetails(
                                            countryCode: CountryCodeType.ENG
                                    )
                            )
                    )
            )

        when:
            boolean playerIsOfGivenCountry = objectUnderTest.isPlayerOfGivenCountry(playerDetails, COUNTRY_CODE_ENG);

        then:
            playerIsOfGivenCountry
    }

    def "should return true if country code is the same when creating nested structures using spock mocks - requires CGLIB for non interface types"() {
        given:
            PlayerDetails playerDetails = Mock()
            ClubDetails clubDetails = Mock()
            CountryDetails countryDetails = Mock()
            CountryCodeDetails countryCodeDetails = Mock()
            countryCodeDetails.countryCode >> CountryCodeType.ENG
            countryDetails.countryCode >> countryCodeDetails
            clubDetails.country >> countryDetails
            playerDetails.clubDetails >> clubDetails

        when:
            boolean playerIsOfGivenCountry = objectUnderTest.isPlayerOfGivenCountry(playerDetails, COUNTRY_CODE_ENG);

        then:
            playerIsOfGivenCountry
    }


    def "should return true if country code is the same using ExtendedSpockSpecification's createNestedMocks"() {
        given:
            PlayerDetails playerDetails = Mock()
            CountryCodeDetails countryCodeDetails = createNestedMocks(playerDetails, "clubDetails.country.countryCode")
            countryCodeDetails.countryCode >> CountryCodeType.ENG

        when:
            boolean playerIsOfGivenCountry = objectUnderTest.isPlayerOfGivenCountry(playerDetails, COUNTRY_CODE_ENG);

        then:
            playerIsOfGivenCountry
    }

    def "should return false if country code is not the same using ExtendedSpockSpecification createNestedMocks"() {
        given:
            PlayerDetails playerDetails = Mock()
            CountryCodeDetails countryCodeDetails = createNestedMocks(playerDetails, "clubDetails.country.countryCode")
            countryCodeDetails.countryCode >> CountryCodeType.PL

        when:
            boolean playerIsOfGivenCountry = objectUnderTest.isPlayerOfGivenCountry(playerDetails, COUNTRY_CODE_ENG);

        then:
            !playerIsOfGivenCountry
    }

    def "should return true if country code is the same using ExtendedSpockSpecification's createNestedSpies"() {
        given:
            PlayerDetails playerDetails = Spy()
            CountryCodeDetails countryCodeDetails = createNestedSpies(playerDetails, "clubDetails.country.countryCode")
            countryCodeDetails.countryCode = CountryCodeType.ENG

        when:
            boolean playerIsOfGivenCountry = objectUnderTest.isPlayerOfGivenCountry(playerDetails, COUNTRY_CODE_ENG);

        then:
            playerIsOfGivenCountry
    }

    def "should return false if country code is not the same using ExtendedSpockSpecification's createNestedSpies"() {
        given:
            PlayerDetails playerDetails = Spy()
            CountryCodeDetails countryCodeDetails = createNestedSpies(playerDetails, "clubDetails.country.countryCode")
            countryCodeDetails.countryCode = CountryCodeType.PL

        when:
            boolean playerIsOfGivenCountry = objectUnderTest.isPlayerOfGivenCountry(playerDetails, COUNTRY_CODE_ENG);

        then:
            !playerIsOfGivenCountry
    }


}