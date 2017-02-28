package org.after90.service;

import lombok.extern.slf4j.Slf4j;
import org.after90.repository.KafkaRepository;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaogj on 28/02/2017.
 */
@Service
@Slf4j
public class DataToKafkaService {
    @Autowired
    private KafkaRepository kafka;

    public void dataToKafka() {
        for (int i = 0; i < 1000; i++) {
            String strKey = "key " + i + " ";
            String strValue = "value " + i + " ";
            long lNow = System.currentTimeMillis();
            kafka.producer.send(new ProducerRecord<String, String>("topic_test", strKey + lNow, strValue + lNow));
            log.info("data to kafka, key:{}", strKey);
        }
    }
}
