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
        while (true) {
            String strKey = "this is key ";
            String strValue = "this is value ";
            long lNow = System.currentTimeMillis();
            kafka.producer.send(new ProducerRecord<String, String>("topic_test", strKey + lNow, strValue + lNow));
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                log.error("", e);
            }
        }
    }
}
