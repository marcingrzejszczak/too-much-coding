package com.blogspot.toomuchcoding.mixin

@Mixin([RunningAbility, DribblingAbility])
class FootballPlayer implements Athlete {
    String getName() {
        return "Robert Lewandowski" 
    }
}
