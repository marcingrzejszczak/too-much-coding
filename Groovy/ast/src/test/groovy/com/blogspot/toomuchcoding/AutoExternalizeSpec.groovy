package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.externalized.ExternalizedPlayer
import com.blogspot.toomuchcoding.util.SerializationUtil
import spock.lang.Specification

class AutoExternalizeSpec extends Specification {

    def "should serialize and deserialize object"() {        
        given:
            ExternalizedPlayer objectUnderTest = new ExternalizedPlayer(name: "name", surname: "surname")
        
        when:
            def deserializedObject = SerializationUtil.serializeAndBack(objectUnderTest)
        
        then:
            deserializedObject.name == objectUnderTest.name
            deserializedObject.surname == objectUnderTest.surname
    }
    
}
