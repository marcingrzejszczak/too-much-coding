package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.category.AnnotatedTensCategory
import com.blogspot.toomuchcoding.category.TensCategory
import spock.lang.Specification

class CategorySpec extends Specification {
    
    def "should mix in new functionality using TensCategory"() {        
        when:
            def result
            use(TensCategory) {
                result = 4.tens
            }
        then:
            40 == result

    }
    
    def "should mix in new functionality using AnnotatedTensCategory"() {        
        when:
            def result
            use(AnnotatedTensCategory) {
                result = 4.annotatedTens
            }
        then:
            40 == result
    }
}
