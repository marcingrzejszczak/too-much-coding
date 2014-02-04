package baseScript

import com.blogspot.toomuchcoding.basescript.NewBaseScript
import groovy.transform.BaseScript

println "Hello"

@BaseScript NewBaseScript newBaseScript

assert newBaseScript == this
return hello()