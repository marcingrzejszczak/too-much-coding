package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.equalshashcode.EqualsAndHashCodePlayer
import spock.lang.Specification

class EqualsAndHashCodeSpec extends Specification {
    
    def "should return true for equal player objects "() {
        given:
            EqualsAndHashCodePlayer player = new EqualsAndHashCodePlayer(name: "name", surname: "surname") 
            EqualsAndHashCodePlayer player2 = new EqualsAndHashCodePlayer(name: "name", surname: "surname")
        expect:
            player == player2 
    }
    
    def "should insert one entry in map for the same player"() {
        given:
            EqualsAndHashCodePlayer player = new EqualsAndHashCodePlayer(name: "name", surname: "surname")
            def map = [(player): "one"]
        when:
            map[player] = "two"
        then:
            map.size() == 1
            map[player] == "two"
    }
}
