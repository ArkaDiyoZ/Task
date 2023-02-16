package com.auto.task.controllers
import com.auto.task.dto.CarDto
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Future

// Почему продусер "оформлен" в контроллере, почему не как "сервис"?
@RestController
class KafkaController(
) {

    @GetMapping("/produce")
    fun produceMessage(@RequestParam("message") message: String): ResponseEntity<String> {
        var producerRecord: ProducerRecord<String, String> = ProducerRecord("cars", message) // зачем использована мутабельная переменная?

        val map = mutableMapOf<String, String>()
        map["key.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
        map["value.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
        // настройки подключения лучше хранить в файлах конфигурации
        map["bootstrap.servers"] = "localhost:29092"

        // на каждый вызов создаем новый продусер, можно при запуске приложения один раз его создать и потом просто переиспользовать?
        var producer = KafkaProducer<String, String>(map as Map<String, Any>?) // зачем использована мутабельная переменная?
        // в кафку принято сериализованные(json например) объекты отправлять, а не просто строки.
        var future: Future<RecordMetadata> = producer?.send(producerRecord)!! // зачем использована мутабельная переменная?
        return ResponseEntity.ok(" message sent to " + future.get().topic());
    }
}
