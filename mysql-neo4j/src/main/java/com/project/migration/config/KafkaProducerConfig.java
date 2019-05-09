package com.project.migration.config;




import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Properties;


@Configuration
public class KafkaProducerConfig {


    @Value("${kafka.connection.url}")
    private String kafkaUrl;

    @Value("${request.required.acks}")
    private String requestAcknowledgement;

    @Value("${kafka.job.topic}")
    private String kafkaTopic;

    // Video message producer
    @Bean(name = "videoMessageProducer")
    public MessageProducer<String> createVideoMessageProducer() throws Exception {
        ProducerMetadata<String, String> metadata = new ProducerMetadata<>(
                kafkaTopic,
                String.class,
                String.class,
                new StringSerializer(),
                new StringSerializer());
        return new MessageProducerImpl<>(kafkaUrl, metadata, producerProperties());
    }


    private Properties producerProperties() {
        Properties properties = new Properties();
        // properties.put("request.required.acks", requestAcknowledgement);
        return properties;
    }
}
