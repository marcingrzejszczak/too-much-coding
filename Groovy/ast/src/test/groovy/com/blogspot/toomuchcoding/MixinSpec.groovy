package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.mixin.FootballPlayer
import com.blogspot.toomuchcoding.mixin.TennisPlayer
import spock.lang.Specification

class MixinSpec extends Specification {
    def "should make football player run"() {
        given:
            def player = new FootballPlayer() 
        expect: 
            player.run() =~ /^.*run.$/
    }
    
    def "should make football player dribble"() {
        given:
            def player = new FootballPlayer()
        expect:
            player.dribble() =~ /^.*dribble.$/
    }
    
    def "should make tennis player run"() {
        given:
            def player = new TennisPlayer()
        expect:
            player.run() =~ /^.*run.$/
    }
    
    def "should make tennis player dribble"() {
        given:
            def player = new TennisPlayer()
        expect:
            player.backhand() =~ /^.*backhand.$/
    }
}
