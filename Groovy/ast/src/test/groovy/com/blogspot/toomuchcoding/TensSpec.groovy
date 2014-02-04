package com.blogspot.toomuchcoding

import spock.lang.Specification

class TensSpec extends Specification {
    
    def "should calculate ten times given number"() {        
        given:
            int initialNumber = 4
        when:
            int calculatedNumber = getTimesTenOf(initialNumber)
        then:
            40 == calculatedNumber       
    }

    Integer getTimesTenOf(Integer number) {
        return 10 * number;
    }
    
    def "should calculate ten times given number by mixing a method to object"() {
        given:
            int initialNumber = 4
        and:
            initialNumber.metaClass.getTimesTen = {
                return 10 * delegate
            }
        when:
            int calculatedNumber = 4.timesTen
        then:
            40 == calculatedNumber
    }
    
    def "should calculate ten times given number by mixing a method to class"() {
        given:
            Integer.metaClass.getTimesTen = {
                return 10 * delegate
            }
        when:
            int calculatedNumber = 4.timesTen
        then:
            40 == calculatedNumber
    }
    
    def cleanup() {
        Integer.metaClass = null    
    }
}
