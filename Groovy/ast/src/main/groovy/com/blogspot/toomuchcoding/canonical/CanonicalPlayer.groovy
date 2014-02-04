package com.blogspot.toomuchcoding.canonical

import groovy.transform.Canonical

@Canonical
class CanonicalPlayer {
    String name, surname
    Collection positions
    int age
    Map skills
}