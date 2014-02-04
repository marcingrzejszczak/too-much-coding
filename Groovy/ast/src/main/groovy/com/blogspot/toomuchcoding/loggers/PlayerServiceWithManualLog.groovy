package com.blogspot.toomuchcoding.loggers

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PlayerServiceWithManualLog {
    private static final Logger log = LoggerFactory.getLogger(PlayerServiceWithManualLog)

    void someMethod() {
        log.info("HOW MANY TIMES DID YOU HAVE TO WRITE THAT LOGGER?")
    }
}
