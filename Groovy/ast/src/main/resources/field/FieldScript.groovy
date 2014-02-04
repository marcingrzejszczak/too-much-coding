package field

import groovy.transform.Field

@Field def newMap = ["key" : "value"]

String someOtherMethod() {
    return newMap["key"]
}

return someOtherMethod()