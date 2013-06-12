package com.blogspot.toomuchcoding.service;

import com.blogspot.toomuchcoding.factory.PlayerFactory;
import com.blogspot.toomuchcoding.model.*;

/**
 * User: mgrzejszczak
 * Date: 08.06.13
 * Time: 19:02
 */
public class PlayerServiceImpl implements PlayerService {

    private PlayerFactory playerFactory;

    @Override
    public Player playAGameWithAPlayerOfPosition(PositionType positionType) {
        Player player = playerFactory.createPlayer(positionType);
        player.run();
        performAdditionalActions(player);
        return player;
    }

    private void performAdditionalActions(Player player) {
        if(player instanceof OffensivePlayer){
            OffensivePlayer offensivePlayer = (OffensivePlayer) player;
            performAdditionalActionsForTheOffensivePlayer(offensivePlayer);
        }else if(player instanceof DefensivePlayer){
            DefensivePlayer defensivePlayer = (DefensivePlayer) player;
            performAdditionalActionsForTheDefensivePlayer(defensivePlayer);
        }
    }

    private void performAdditionalActionsForTheOffensivePlayer(OffensivePlayer offensivePlayer){
        offensivePlayer.shoot();
    }

    private void performAdditionalActionsForTheDefensivePlayer(DefensivePlayer defensivePlayer){
        defensivePlayer.defend();
        try{
            DJ dj = (DJ)defensivePlayer;
            dj.playSomeMusic();
            JavaDeveloper javaDeveloper = (JavaDeveloper)defensivePlayer;
            javaDeveloper.doSomeSeriousCoding();
        }catch(ClassCastException exception){
            System.err.println("Sorry, I can't do more than just play football...");
        }
    }

    public PlayerFactory getPlayerFactory() {
        return playerFactory;
    }

    public void setPlayerFactory(PlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }
}
