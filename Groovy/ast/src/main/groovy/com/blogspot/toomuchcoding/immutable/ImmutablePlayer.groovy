package com.blogspot.toomuchcoding.immutable

import groovy.transform.Immutable

@Immutable
class ImmutablePlayer {
    String name
    MutablePlayer mutablePlayer
}
