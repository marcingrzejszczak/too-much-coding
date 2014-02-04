package com.blogspot.toomuchcoding.tostring

import groovy.transform.ToString

@ToString(includeSuper = true, includeNames = true)
class ChildPlayer extends BasePlayer {
    int age
}
