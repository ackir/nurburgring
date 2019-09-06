package com.aytunccankir.nurburgring.configuration.properties.consumer

import com.aytunccankir.nurburgring.configuration.abstracts.AbstractMQConfiguration
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueueConfiguration : AbstractMQConfiguration() {

    @Bean
    fun slowLaneExchange(mqProperties: SlowLaneMQProperties): TopicExchange = buildTopicExchange(mqProperties)

    @Bean
    fun mediumLaneExchange(mqProperties: MediumLaneMQProperties): TopicExchange = buildTopicExchange(mqProperties)

    @Bean
    fun fastLaneExchange(mqProperties: FastLaneMQProperties): TopicExchange = buildTopicExchange(mqProperties)

    @Bean
    fun slowLaneQueue(mqProperties: SlowLaneMQProperties): Queue = buildQueue(mqProperties)

    @Bean
    fun mediumLaneQueue(mqProperties: MediumLaneMQProperties): Queue = buildQueue(mqProperties)

    @Bean
    fun fastLaneQueue(mqProperties: FastLaneMQProperties): Queue = buildQueue(mqProperties)

    @Bean
    fun slowLaneDeadLetterQueue(mqProperties: SlowLaneMQProperties): Queue = buildDeadLetterQueue(mqProperties)

    @Bean
    fun mediumLaneDeadLetterQueue(mqProperties: MediumLaneMQProperties): Queue = buildDeadLetterQueue(mqProperties)

    @Bean
    fun fastLaneDeadLetterQueue(mqProperties: FastLaneMQProperties): Queue = buildDeadLetterQueue(mqProperties)

    @Bean
    fun slowLaneQueueBinding(slowLaneQueue: Queue, slowLaneExchange: TopicExchange, mqProperties: SlowLaneMQProperties): Binding =
            bindQueueWithRoutingKey(slowLaneQueue, slowLaneExchange, mqProperties.routingKey!!)

    @Bean
    fun mediumLaneQueueBinding(mediumLaneQueue: Queue, mediumLaneExchange: TopicExchange, mqProperties: MediumLaneMQProperties): Binding =
            bindQueueWithRoutingKey(mediumLaneQueue, mediumLaneExchange, mqProperties.routingKey!!)

    @Bean
    fun fastLaneQueueBinding(fastLaneQueue: Queue, fastLaneExchange: TopicExchange, mqProperties: FastLaneMQProperties): Binding =
            bindQueueWithRoutingKey(fastLaneQueue, fastLaneExchange, mqProperties.routingKey!!)
}
