package com.blogspot.toomuchcoding

import spock.lang.Specification

class FieldSpec extends Specification {
    def "should throw exception due to undefined variable"() {
        given:
            Class baseScript =  new GroovyClassLoader().parseClass(this.getClass().getResource("/field/WrongFieldScript.groovy").text)
            Script script = (Script) baseScript.newInstance()
        when:
            script.run()
        then:
            thrown(MissingPropertyException)
    }
    
    def "should return value from @Field annotated map"() {
        given:
            Class baseScript =  new GroovyClassLoader().parseClass(this.getClass().getResource("/field/FieldScript.groovy").text)
            Script script = (Script) baseScript.newInstance()
        when:
            def result = script.run()
        then:
            result == "value"
    }
}
