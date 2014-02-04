package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.basescript.NewBaseScript
import spock.lang.Specification

class BaseScriptSpec extends Specification {
    
    def "should make script return the @BaseScript annotated object"() {
        given:
            Class baseScript =  new GroovyClassLoader().parseClass(this.getClass().getResource("/baseScript/SomeScript.groovy").text)
            Script script = (Script) baseScript.newInstance()
        when:
            def result = script.run()
        then:
            NewBaseScript.OUTPUT_MSG == result
    }
    
}
