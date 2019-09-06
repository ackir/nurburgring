package com.aytunccankir.nurburgring.configuration.abstracts

import java.util.*

abstract class AbstractMQProperties {

    var exchange: String? = null
    var routingKey: String? = null
    var queue: String? = null
    var deadLetterQueue: String? = null
    var args: Map<String, Any> = HashMap()
}