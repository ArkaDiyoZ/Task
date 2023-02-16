package com.auto.task.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumerService {

    @KafkaListener(topics=["cars"], groupId = "listeners_id")
    private fun consume(message:String) :Unit {
        println(" message received from topic : $message");
    }
}