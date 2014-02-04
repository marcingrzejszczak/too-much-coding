package com.blogspot.toomuchcoding.inheritconstructors

/**
 * You have to write the constructors yourself or make IDE generate it for you...
 */
class MyRuntimeException extends RuntimeException {
    MyRuntimeException() {
    }

    MyRuntimeException(String s) {
        super(s)
    }

    MyRuntimeException(String s, Throwable throwable) {
        super(s, throwable)
    }

    MyRuntimeException(Throwable throwable) {
        super(throwable)
    }

    MyRuntimeException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1)
    }
}
