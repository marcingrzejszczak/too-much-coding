package com.blogspot.toomuchcoding

import spock.lang.Specification

class CustomAstSpec extends Specification {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream()    
    
    def setup() {
        System.out = new PrintStream(outContent)
    }
    
    def "should print content of the method in the script together with the logic from AST transform"() {
        given: 
            Class baseScript =  new GroovyClassLoader().parseClass(this.getClass().getResource("/ast/ClassWithAst.groovy").text)
            Script script = (Script) baseScript.newInstance()
        when:
            script.run()
        then:
            "Starting doSth\r\n"+
            "In the middle\r\n"+
            "Ending doSth\r\n" == outContent.toString()
    }
    
    def cleanup() {
        System.out = null
    }
}
