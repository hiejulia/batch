package com.project.batch.service.producer;



import com.project.batch.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Collection;

@Service
public class KafkaProducerService {
    // Autowired : Kafka Template

    @Autowired
    private KafkaTemplate<String, user> kafkaTemplate;

    @Value("${kafka.csv.topic}")
    private String topic;



    /**
     * Created using the following
     * 1) zookeeper-server-start.bat ..\..\config\zookeeper.properties
     * 2) kafka-server-start.bat ..\..\config\server.properties
     * 3) Create topic:
     * 		kafka-topics.bat --create --zookeeper localhost:2181
     * 	   --replication-factor 1 --partitions 1 --topic KAFKA_EXAMPLE_TOPIC
     * 4) Consume from console:
     * 		kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic KAFKA_EXAMPLE_TOPIC
     * 		--from-beginning
     * 5) Produce from console:
     * 		 kafka-console-producer.bat --broker-list localhost:9092 --topic KAFKA_EXAMPLE_TOPIC
     * @param users
     *
     */
    public void publishUser(Collection<? extends user> users){
        // kafka template send
            // send to topic - user
        users.forEach(user -> {
            kafkaTemplate.send(topic, user).addCallback(new ListenableFutureCallback<SendResult<String, user>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    // fail to publish to the broker
                }

                @Override
                public void onSuccess(SendResult<String, user> stringUserSendResult) {
                    //

                }
            });
        });
    }
}



