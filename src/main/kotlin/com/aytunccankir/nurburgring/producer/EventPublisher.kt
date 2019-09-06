package com.aytunccankir.nurburgring.producer

import com.aytunccankir.nurburgring.configuration.properties.producer.RoutingKeys
import com.aytunccankir.nurburgring.model.Car
import com.aytunccankir.nurburgring.model.Event
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class EventPublisher(private val rabbitTemplate: RabbitTemplate) {

    fun publish(event: Event) {
        when {
            event.car!! == Car.TRUCK -> publishEvent(exchange, RoutingKeys.SLOW_LANE.routingKey, event)
            event.car!! == Car.MINIVAN -> publishEvent(exchange, RoutingKeys.MEDIUM_LANE.routingKey, event)
            else -> publishEvent(exchange, RoutingKeys.FAST_LANE.routingKey, event)
        }
    }

    private fun publishEvent(exchange: String, routingKey: String, message: Any) = try {
        rabbitTemplate.convertAndSend(exchange, routingKey, message)
    } catch (e: Exception) {
        log(message, e)
    }

    private fun log(message: Any, e: Exception) = LOGGER.error("Error on publishing :{}, message :{}", e, message)

    companion object {
        const val exchange = "mq.nurburgring.events"
        private val LOGGER = LoggerFactory.getLogger(EventPublisher::class.java)
    }
}