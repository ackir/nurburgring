package com.aytunccankir.nurburgring.controller

import com.aytunccankir.nurburgring.model.Car
import com.aytunccankir.nurburgring.model.Event
import com.aytunccankir.nurburgring.producer.EventPublisher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/nurburgring")
class EventController(private val eventPublisher: EventPublisher) {

    @PostMapping
    fun campaignsBySupplier(@RequestParam("carType") carType: Car?) =
            eventPublisher.publish(Event().apply { car = carType })
}