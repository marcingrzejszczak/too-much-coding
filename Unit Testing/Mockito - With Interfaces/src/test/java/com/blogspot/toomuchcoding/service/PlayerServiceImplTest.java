package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.factory.PlayerFactory;
import com.blogspot.toomuchcoding.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;

/**
 * User: mgrzejszczak
 * Date: 08.06.13
 * Time: 19:26
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceImplTest {

    @Mock
    PlayerFactory playerFactory;

    @InjectMocks
    PlayerServiceImpl objectUnderTest;

    @Mock(extraInterfaces = {DJ.class, JavaDeveloper.class})
    DefensivePlayer defensivePlayerWithDjAndJavaDevSkills;

    @Mock
    DefensivePlayer defensivePlayer;

    @Mock
    OffensivePlayer offensivePlayer;

    @Mock
    Player commonPlayer;

    @Test
    public void shouldReturnOffensivePlayerThatRan() throws Exception {
        //given
        given(playerFactory.createPlayer(PositionType.ATT)).willReturn(offensivePlayer);

        //when
        Player createdPlayer = objectUnderTest.playAGameWithAPlayerOfPosition(PositionType.ATT);

        //then
        assertThat(createdPlayer == offensivePlayer, is(true));
        verify(offensivePlayer).run();
    }

    @Test
    public void shouldReturnDefensivePlayerButHeWontBeADjNorAJavaDev() throws Exception {
        //given
        given(playerFactory.createPlayer(PositionType.GK)).willReturn(defensivePlayer);

        //when
        Player createdPlayer = objectUnderTest.playAGameWithAPlayerOfPosition(PositionType.GK);

        //then
        assertThat(createdPlayer == defensivePlayer, is(true));
        verify(defensivePlayer).run();
        verify(defensivePlayer).defend();
        verifyNoMoreInteractions(defensivePlayer);
    }

    @Test
    public void shouldReturnDefensivePlayerBeingADjAndAJavaDev() throws Exception {
        //given
        given(playerFactory.createPlayer(PositionType.GK)).willReturn(defensivePlayerWithDjAndJavaDevSkills);
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                System.out.println("Hit me baby one more time!");
                return null;
            }
        }).when(((DJ) defensivePlayerWithDjAndJavaDevSkills)).playSomeMusic();
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                System.out.println("public static void main(String... args){\n}");
                return null;
            }
        }).when(((JavaDeveloper) defensivePlayerWithDjAndJavaDevSkills)).doSomeSeriousCoding();

        //when
        Player createdPlayer = objectUnderTest.playAGameWithAPlayerOfPosition(PositionType.GK);

        //then
        assertThat(createdPlayer == defensivePlayerWithDjAndJavaDevSkills, is(true));
        verify(defensivePlayerWithDjAndJavaDevSkills).run();
        verify(defensivePlayerWithDjAndJavaDevSkills).defend();
        verify((DJ) defensivePlayerWithDjAndJavaDevSkills).playSomeMusic();
        verify((JavaDeveloper) defensivePlayerWithDjAndJavaDevSkills).doSomeSeriousCoding();
    }

    @Test
    public void shouldReturnDefensivePlayerBeingADjAndAJavaDevByUsingWithSettings() throws Exception {
        //given
        DefensivePlayer defensivePlayerWithDjAndJavaDevSkills = mock(DefensivePlayer.class, withSettings().extraInterfaces(DJ.class, JavaDeveloper.class));
        given(playerFactory.createPlayer(PositionType.GK)).willReturn(defensivePlayerWithDjAndJavaDevSkills);
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                System.out.println("Hit me baby one more time!");
                return null;
            }
        }).when(((DJ) defensivePlayerWithDjAndJavaDevSkills)).playSomeMusic();
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                System.out.println("public static void main(String... args){\n}");
                return null;
            }
        }).when(((JavaDeveloper) defensivePlayerWithDjAndJavaDevSkills)).doSomeSeriousCoding();

        //when
        Player createdPlayer = objectUnderTest.playAGameWithAPlayerOfPosition(PositionType.GK);

        //then
        assertThat(createdPlayer == defensivePlayerWithDjAndJavaDevSkills, is(true));
        verify(defensivePlayerWithDjAndJavaDevSkills).run();
        verify(defensivePlayerWithDjAndJavaDevSkills).defend();
        verify((DJ) defensivePlayerWithDjAndJavaDevSkills).playSomeMusic();
        verify((JavaDeveloper) defensivePlayerWithDjAndJavaDevSkills).doSomeSeriousCoding();
    }

    @Test
    public void shouldReturnCommonPlayer() throws Exception {
        //given
        given(playerFactory.createPlayer(null)).willReturn(commonPlayer);

        //when
        Player createdPlayer = objectUnderTest.playAGameWithAPlayerOfPosition(null);

        //then
        assertThat(createdPlayer, is(commonPlayer));
    }
}
