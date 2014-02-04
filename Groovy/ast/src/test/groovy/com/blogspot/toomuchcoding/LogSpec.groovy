package com.blogspot.toomuchcoding

import com.blogspot.toomuchcoding.loggers.PlayerServiceWithLog
import spock.lang.Specification

class LogSpec extends Specification {
    def "should add logger through ast"() {
        expect:
            PlayerServiceWithLog.log != null        
    }
}
