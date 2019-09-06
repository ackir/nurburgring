package com.aytunccankir.nurburgring.consumer

import com.aytunccankir.nurburgring.model.Event
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class EventConsumer {

    @RabbitListener(queues = ["\${mq.nurburgring.queues.slow-lane.queue}"])
    fun slowLaneMQ(event: Event) {
        consume(event)
    }

    @RabbitListener(queues = ["\${mq.nurburgring.queues.medium-lane.queue}"])
    fun mediumLaneMQ(event: Event) {
        consume(event)
    }

    @RabbitListener(queues = ["\${mq.nurburgring.queues.fast-lane.queue}"])
    fun fastLaneMQ(event: Event) {
        consume(event)
    }

    private fun consume(event: Event) {
        LOGGER.info("Event consumed..." + event.car)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EventConsumer::class.java)
    }
}
