package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.compilestatic.CompileStaticAndTypeChecked
import com.blogspot.toomuchcoding.compilestatic.DynamicPlayer
import spock.lang.Specification

import static com.blogspot.toomuchcoding.compilestatic.DynamicPlayer.getORIGINAL_RESULT

class CompileStaticAndTypeCheckSpec extends Specification {
    
    static final String OVERLOADED_RESULT = ""
    
    def setupSpec() {
        DynamicPlayer.metaClass.getUnknownType = { OVERLOADED_RESULT }
    }
    
    def "should return injected method's result for @TypeChecked annotated method"() {
        given:
            CompileStaticAndTypeChecked object = new CompileStaticAndTypeChecked()        
        when:
            String result = object.typed()
        then:
            OVERLOADED_RESULT == result
    }

    def "should return original method's result for @CompileStatic annotated method"() {
        given:
            CompileStaticAndTypeChecked object = new CompileStaticAndTypeChecked()
        when:
            String result = object.compiled()
        then:
            ORIGINAL_RESULT == result
    }

    def cleanupSpec() {
        DynamicPlayer.metaClass = null
    }
}
