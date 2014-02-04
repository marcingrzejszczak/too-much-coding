package com.blogspot.toomuchcoding.mixin

@Category(Athlete)
class RunningAbility {
    def run() {
        return "My name is [${name}]. I can run." 
    }
}
