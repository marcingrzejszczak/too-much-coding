package com.blogspot.toomuchcoding.compilestatic

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

class CompileStaticAndTypeChecked {
    DynamicPlayer player

    CompileStaticAndTypeChecked() {
        player = new DynamicPlayer()
    }

    /**
     * There is no method bar yet the code compiles - try to add @TypeChecked or @CompileStatic and the code won't compile
     * @return
     */
    def groovy() {
        player.bar
    }

    @TypeChecked
    def typed() {
        player.unknownType
    }

    @CompileStatic
    def compiled() {
        player.unknownType
    }
}
