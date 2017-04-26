package org.after90.component;

import lombok.extern.slf4j.Slf4j;
import org.after90.repository.KafkaRepository;
import org.after90.service.DataFromKafkaService;
import org.after90.service.DataToKafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by zhaogj on 16/02/2017.
 */
@Component
@Slf4j
@Order(value = 1)
public class StartRunnerComponent implements CommandLineRunner {
    @Autowired
    private KafkaRepository kafkaRepository;
    @Autowired
    private DataToKafkaService dataToKafka;
    @Autowired
    private DataFromKafkaService dataFromKafka;

    @Override
    public void run(String... args) throws Exception {
        log.info("start StartRunnerComponent");
        //kafkaRepository.initProducer();
//        new Thread() {
//            @Override
//            public void run() {
//                dataToKafka.dataToKafka();
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                dataFromKafka.dataFromKafka();
//            }
//        }.start();

        log.info("end StartRunnerComponent");
    }
}
