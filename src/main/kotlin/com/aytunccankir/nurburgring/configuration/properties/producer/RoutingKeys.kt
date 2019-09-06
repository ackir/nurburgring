package com.aytunccankir.nurburgring.configuration.properties.producer

enum class RoutingKeys(val routingKey: String) {

    SLOW_LANE("mq.nurburgring.slowLane"),
    MEDIUM_LANE("mq.nurburgring.mediumLane"),
    FAST_LANE("mq.nurburgring.fastLane")
}