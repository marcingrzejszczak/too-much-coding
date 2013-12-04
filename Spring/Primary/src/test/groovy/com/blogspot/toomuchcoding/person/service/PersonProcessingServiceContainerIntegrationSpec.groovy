package com.blogspot.toomuchcoding.person.service
import com.blogspot.toomuchcoding.configuration.SpringConfiguration
import com.blogspot.toomuchcoding.person.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

import static org.hamcrest.CoreMatchers.notNullValue

@ContextConfiguration(classes = [SpringConfiguration])
class PersonProcessingServiceContainerIntegrationSpec extends Specification {

    @Autowired
    PersonProcessingService personProcessingService
    
    def "should autowire container even though there are many implementations of service"(){       
        expect: 
            personProcessingService instanceof PersonProcessingServiceContainer
    }
    
    def "the autowired container should not have itself in the list of autowired services"(){       
        expect: 
            personProcessingService instanceof PersonProcessingServiceContainer
        and:
            !(personProcessingService as PersonProcessingServiceContainer).personProcessingServices.findResult {
                it instanceof PersonProcessingServiceContainer
            }
    }
    
    def "should not be applicable for processing if a person doesn't exist"(){
        given:
            Person person = null
        expect:
            !personProcessingService.isApplicableFor(person)
    }
    
    def "should return an empty result for a person not applicable for anything"(){
        given:
            Person person = new Person("", 17, false)
        when:
            def result = personProcessingService.process(person)
        then:
            result notNullValue()
            result.isEmpty()
    }

    @Unroll("For name [#name], age [#age] and being stupid [#stupid] the result should contain keywords #keywords")
    def "should perform different processing depending on input"(){
        given:
            Person person = new Person(name, age, stupid)
        when:
            def result = personProcessingService.process(person)        
        then:
            keywords.every {
                result.contains(it)    
            }
        where:
            name  | age | stupid || keywords
            "jan" | 20  | true   || ['NAME', 'AGE', 'STUPID']
            ""    | 20  | true   || ['AGE', 'STUPID']
            ""    | 20  | false  || ['AGE']
            null  | 17  | true   || ['STUPID']
            "jan" | 17  | true   || ['NAME']
    }
}
