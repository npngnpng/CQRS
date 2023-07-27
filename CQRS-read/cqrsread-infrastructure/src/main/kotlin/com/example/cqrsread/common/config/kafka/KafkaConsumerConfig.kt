package com.example.cqrsread.common.config.kafka

import com.example.cqrsread.domain.feed.event.vo.CreateFeedEvent
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig(
    @Value(value = "\${kafka.bootstrap-servers}")
    private val servers: String
) {

    @Bean
    fun createFeedEventContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, CreateFeedEvent> {
        return createContainerFactory(CreateFeedEvent::class.java)
    }

    private fun <T> createContainerFactory(type: Class<T>): ConcurrentKafkaListenerContainerFactory<String, T> {
        return ConcurrentKafkaListenerContainerFactory<String, T>().apply {
            consumerFactory = createKafkaConsumerFactory(type)
        }
    }

    private fun <T> createKafkaConsumerFactory(type: Class<T>): DefaultKafkaConsumerFactory<String, T> {
        return DefaultKafkaConsumerFactory(
            getConsumerProps(),
            StringDeserializer(),
            createJsonDeserializer(type)
        )
    }

    private fun getConsumerProps(): Map<String, Any> {
        return HashMap<String, Any>().apply {
            put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers)
            put(ConsumerConfig.GROUP_ID_CONFIG, "foo")
            put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
            put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer::class.java)
        }
    }

    private fun <T> createJsonDeserializer(type: Class<T>): JsonDeserializer<T> {
        return JsonDeserializer(type).apply {
            setRemoveTypeHeaders(false)
            addTrustedPackages("*")
            setUseTypeMapperForKey(true)
        }
    }
}