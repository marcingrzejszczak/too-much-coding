package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.delegate.DelegatePlayer
import spock.lang.Specification

class DelegateSpec extends Specification {

    public static final int ROBERT_VALUE = 30_000_000
    public static final int WOJCIECH_VALUE = 10_000_000

    def "should calculate total amount by allowing a player to call big decimal methods"() {
        given:
            DelegatePlayer robert = new DelegatePlayer(name: "robert", surname: "lewandowski", value: ROBERT_VALUE)
            DelegatePlayer wojciech = new DelegatePlayer(name: "wojciech", surname: "szczesny", value: WOJCIECH_VALUE)
        when:
            BigDecimal totalAmount = robert.add(wojciech.value)
        then:
            totalAmount == ROBERT_VALUE + WOJCIECH_VALUE
    }
}
