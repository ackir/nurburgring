package com.aytunccankir.nurburgring.configuration.properties.consumer


import com.aytunccankir.nurburgring.configuration.abstracts.AbstractMQProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "mq.nurburgring.queues.slow-lane")
class SlowLaneMQProperties : AbstractMQProperties()
