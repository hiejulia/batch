//package com.project.batch.config;
//
//
//
//import com.project.batch.model.user;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.listener.AbstractMessageListenerContainer;
//import org.springframework.kafka.listener.ErrorHandler;
//import org.springframework.kafka.listener.KafkaListenerErrorHandler;
//import org.springframework.kafka.listener.ListenerExecutionFailedException;
//
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.springframework.kafka.listener.AbstractMessageListenerContainer.*;
//
//@Configuration
//@EnableKafka
//public class KafkaConfig {
//
//    private String groupId;
//
//    @Bean
//    public String groupId(@Value("${kafka.csv.group.id}") String groupId) {
//        this.groupId = groupId;
//        return groupId;
//    }
//
//    @Bean
//    public ProducerFactory<String, user> producerFactory(){
//        Map<String, Object> config = new HashMap<>();
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1 :9092");
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(config);
//    }
//
//    @Bean
//    public KafkaTemplate<String, user> kafkaTemplate(){
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean
//    public ConsumerFactory<String, user> consumerFactory(){
//        Map<String, Object> config = new HashMap<>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, user.class);
//        return new DefaultKafkaConsumerFactory<user>(config, new StringDeserializer(), new user());
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, user> kafkaListenerContainerFactory(){
//        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//
//    // cai nay su dung intellij
//
//
//
//
//
//}
