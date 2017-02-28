package org.after90.service;

import lombok.extern.slf4j.Slf4j;
import org.after90.repository.KafkaRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by zhaogj on 28/02/2017.
 */
@Service
@Slf4j
public class DataFromKafkaService {

    @Autowired
    private KafkaRepository kafka;

    public void dataFromKafka() {
        KafkaConsumer<String, String> consumer = kafka.initConsumer();
        consumer.subscribe(Arrays.asList("topic_test"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(10000);
            for (ConsumerRecord<String, String> record : records) {
                log.info("offset = {}, key = {}, value = {}", record.offset(), record.key(), record.value());
            }
            consumer.commitSync();
            log.info("finish commitSync");
        }
    }
}
