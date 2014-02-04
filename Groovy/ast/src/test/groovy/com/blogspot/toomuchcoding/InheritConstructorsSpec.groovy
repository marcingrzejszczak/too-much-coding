package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.inheritconstructors.MySuperRuntimeException
import spock.lang.Specification

class InheritConstructorsSpec extends Specification {
    
    def "should instantiate exceptions"() {    
        expect:
            new MySuperRuntimeException()
            new MySuperRuntimeException("msg")
            new MySuperRuntimeException("msg", new RuntimeException())
            new MySuperRuntimeException(new RuntimeException())
            new MySuperRuntimeException("msg", new RuntimeException(), true, false)
    }
}
