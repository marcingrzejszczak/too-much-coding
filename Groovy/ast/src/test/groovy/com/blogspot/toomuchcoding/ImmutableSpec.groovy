package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.immutable.ImmutablePlayer
import com.blogspot.toomuchcoding.immutable.MutablePlayer
import spock.lang.Specification

class ImmutableSpec extends Specification {
    
    def "should not allow to construct an immutable object with a mutable property"() {
        when:
            new ImmutablePlayer("name", new MutablePlayer(age: 10))
        then:
            RuntimeException exception = thrown()
            exception.message.contains("@Immutable processor doesn't know how to handle field 'mutablePlayer' of type")
    }
}
