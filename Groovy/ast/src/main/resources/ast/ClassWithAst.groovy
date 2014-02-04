package ast

import com.blogspot.toomuchcoding.ast.WithLogging

@WithLogging()
void doSth() {
    println "In the middle"
}

doSth()