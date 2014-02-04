package com.blogspot.toomuchcoding.basescript

class NewBaseScript extends Script {

    static final String OUTPUT_MSG = "Inner hello"

    String hello() {
        return OUTPUT_MSG
    }

    @Override
    Object run() {
        return "script"
    }
}