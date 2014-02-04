package com.blogspot.toomuchcoding.tostring

import groovy.transform.ToString

@ToString(includePackage = false)
class BasePlayer {
    String name, surname
}
