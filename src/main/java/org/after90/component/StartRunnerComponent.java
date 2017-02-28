package org.after90.component;

import lombok.extern.slf4j.Slf4j;
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


    @Override
    public void run(String... args) throws Exception {
        //初始化ES连接信息
        log.info("start init es");

        log.info("end init es");
    }
}
