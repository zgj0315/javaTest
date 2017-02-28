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
        int nCount = 0;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            if (records.count() == 0) {
                nCount++;
                if (nCount > 10) {
                    break;
                }
            } else {
                nCount = 0;
            }
            for (ConsumerRecord<String, String> record : records) {
                //if (record.offset() % 100 == 0) {
                log.info("offset = {}, key = {}, value = {}", record.offset(), record.key(), record.value());
                //}
            }
            consumer.commitSync();
            //log.info("finish commitSync, records.count:{}",records.count());
        }
    }
}
