package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.model.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * User: mgrzejszczak
 * Date: 08.06.13
 * Time: 19:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testApplicationContext.xml")
public class PlayerServiceImplTest {

    public static final String PLAYER_NAME = "Lewandowski";
    public static final BigDecimal PLAYER_VALUE = new BigDecimal("35000000");

    @Autowired
    PlayerWebService playerWebServiceSpy;

    @Autowired
    PlayerService objectUnderTest;

    @Test
    public void shouldReturnAPlayerFromPlayerWebService(){
        //given
        Player referencePlayer = new Player(PLAYER_NAME, PLAYER_VALUE);
        doReturn(referencePlayer).when(playerWebServiceSpy).getPlayerByName(PLAYER_NAME);

        //when
        Player player = objectUnderTest.getPlayerByName(PLAYER_NAME);

        //then
        assertThat(player, is(referencePlayer));
        verify(playerWebServiceSpy).getWebServiceName();
        assertThat(playerWebServiceSpy.getWebServiceName(), is(PlayerWebServiceImpl.WEB_SERVICE_NAME));
    }


}
