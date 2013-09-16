package com.blogspot.toomuchcoding.adapter;

import com.blogspot.toomuchcoding.model.DJ;
import com.blogspot.toomuchcoding.model.DefensivePlayer;
import com.blogspot.toomuchcoding.model.JavaDeveloper;
import com.blogspot.toomuchcoding.model.PlayerDetails;

/**
 * User: mgrzejszczak
 * Date: 09.06.13
 * Time: 15:42
 */
public class DefencePlayerAdapter extends CommonPlayerAdapter implements DefensivePlayer, DJ, JavaDeveloper {

    public DefencePlayerAdapter(PlayerDetails playerDetails){
        super(playerDetails);
    }

    @Override
    public void defend(){
        System.out.printf("Defence! %s. Defence!%n", getPlayerDetails().getName());
    }

    @Override
    public void playSomeMusic() {
        System.out.println("Oops I did it again...!");
    }

    @Override
    public void doSomeSeriousCoding() {
        System.out.println("System.out.println(\"Hello world\");");
    }
}
