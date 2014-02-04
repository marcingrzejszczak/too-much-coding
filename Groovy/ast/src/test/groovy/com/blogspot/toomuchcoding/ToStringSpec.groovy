package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.tostring.ChildPlayer
import spock.lang.Specification

class ToStringSpec extends Specification {
    
    def "should return nice looking to string"() {
        given:
            ChildPlayer childPlayer = new ChildPlayer(name: "Name", surname: "Surname", age: 10)
        when:
            String result = childPlayer.toString()
        then:
            !result.startsWith("${childPlayer.class.name}@")
    }
}
