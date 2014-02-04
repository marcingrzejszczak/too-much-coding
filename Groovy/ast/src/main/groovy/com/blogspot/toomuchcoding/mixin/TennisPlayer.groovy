package com.blogspot.toomuchcoding.mixin

@Mixin([RunningAbility, TennisAbility])
class TennisPlayer implements Athlete {
    String getName() {
        return "Lukasz Kubot" 
    }
}
