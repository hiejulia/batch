package com.project.batch.batch;



import com.project.batch.model.user;
import com.project.batch.service.producer.KafkaProducerService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDbWriter implements ItemWriter<user> {



    @Autowired
    private KafkaProducerService kafkaProducerService;

    /**
     * ItemWriter should send to Kafka for stream processing
     * @param users
     * @throws Exception
     */
    @Override
    public void write(List<? extends user> users) throws Exception {
        kafkaProducerService.publishUser(users);
    }
}