package com.auto.task.service
import com.auto.task.config.KafkaProperties
import com.auto.task.types.KafkaTopics
import com.google.gson.Gson
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.concurrent.Future


@Service
class KafkaProducerService(
    val kafkaProperties: KafkaProperties
) {
    private final val producer: KafkaProducer<String, String>

    init {
        val map = mutableMapOf<String, Any>()
        println(kafkaProperties.keySerializer)
        map["key.serializer"] = kafkaProperties.keySerializer
        map["value.serializer"] = kafkaProperties.valueSerializer
        map["bootstrap.servers"] = kafkaProperties.bootstrapServers
        producer = KafkaProducer(map)
    }

    fun produceMessage(topic: KafkaTopics, jsonObject: Any): ResponseEntity<Any> {
        val obj = Gson().toJson(jsonObject)

        val producerRecord: ProducerRecord<String, String> = ProducerRecord(topic.name, obj)

        val future: Future<RecordMetadata> = producer.send(producerRecord)
        return ResponseEntity.ok(" message sent to " + future.get().topic());
    }
}