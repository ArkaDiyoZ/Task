package com.auto.task.config
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "spring.kafka.producer")
data class KafkaProperties (
    var keySerializer: String = "",
    var valueSerializer: String = "",
    var bootstrapServers: String = ""
)

