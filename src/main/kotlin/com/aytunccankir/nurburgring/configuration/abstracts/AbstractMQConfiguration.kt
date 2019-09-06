package com.aytunccankir.nurburgring.configuration.abstracts

import org.springframework.amqp.core.*

abstract class AbstractMQConfiguration {

    protected fun buildTopicExchange(mqProperties: AbstractMQProperties): TopicExchange =
            ExchangeBuilder.topicExchange(mqProperties.exchange)
                    .durable(true)
                    .suppressDeclaration()
                    .build() as TopicExchange

    protected fun buildQueue(mqProperties: AbstractMQProperties): Queue = QueueBuilder.durable(mqProperties.queue)
            .withArguments(mqProperties.args)
            .build()

    protected fun buildDeadLetterQueue(mqProperties: AbstractMQProperties): Queue =
            QueueBuilder.durable(mqProperties.deadLetterQueue)
                    .build()

    protected fun bindQueueWithRoutingKey(queue: Queue, exchange: TopicExchange, routingKey: String): Binding =
            BindingBuilder.bind(queue).to(exchange).with(routingKey)
}
