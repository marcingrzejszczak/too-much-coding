package com.blogspot.toomuchcoding.mixin

@Category(Athlete)
class DribblingAbility {
    def dribble() { 
        return "My name is [${name}]. I can dribble." 
    }
}
