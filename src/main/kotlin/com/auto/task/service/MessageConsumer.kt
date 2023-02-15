package com.auto.task.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class MessageConsumer {

    @KafkaListener(topics=["cars"], groupId = "test_id")
    fun consume(message:String) :Unit {
        println(" message received from topic : $message");
    }
}