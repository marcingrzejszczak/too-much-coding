package com.blogspot.toomuchcoding.mixin

@Category(Athlete)
class TennisAbility {
    def backhand() {
        return "My name is [${name}]. I can use my backhand." 
    }
}
