package com.blogspot.toomuchcoding.spock;

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: MGrzejszczak
 * Date: 14.06.13
 * Time: 15:26
 */
abstract class ExtendedSpockSpecification extends Specification {
    /**
     * The method creates nested structure of spies for all the elements present in the property parameter. Those spies are set on the input object.
     *
     * @param object - object on which you want to create nested spies
     * @param property - field accessors delimited by a dot - JavaBean convention
     * @return Spy of the last object from the property path
     */
    protected def createNestedSpies(object, String property) {
        def lastObject = object
        property.tokenize('.').inject object, { obj, prop ->
            if (obj[prop] == null) {
                def foundProp = obj.metaClass.properties.find { it.name == prop }
                obj[prop] = Spy(foundProp.type)
            }
            lastObject = obj[prop]
        }
        lastObject
    }

    /**
     * The method creates nested structure of mocks for all the elements present in the property parameter. Those mocks are set on the input object.
     *
     * @param object - object on which you want to create nested mocks
     * @param property - field accessors delimited by a dot - JavaBean convention
     * @return Mock of the last object from the property path
     */
    protected def createNestedMocks(object, String property) {
        def lastObject = object
        property.tokenize('.').inject object, { obj, prop ->
            def foundProp = obj.metaClass.properties.find { it.name == prop }
            def mockedProp = Mock(foundProp.type)
            lastObject."${prop}" >> mockedProp
            lastObject = mockedProp
        }
        lastObject
    }
}
