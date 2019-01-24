package com.project.batch.service.consumer;



import com.project.batch.model.user;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {


    // Consumer
    @KafkaListener(topics= "${kafka.csv.topic}", containerFactory = "kafkaListenerContainerFactory", groupId = ("${kafka.csv.group.id}"))
    public void consume(user user){


    }


}