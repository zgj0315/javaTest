package org.after90.someTest.datetime;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by zhaogj on 23/06/2017.
 */
@Service
@Slf4j
public class DateTimeService {
    public void doSomething() {
        ZonedDateTime zdt = ZonedDateTime.parse("2016-04-27T17:59:06+08:00");
        log.info("zdt:{}", zdt.toString());
        LocalDateTime ldt = LocalDateTime.parse("2016-04-27T07:59:06", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        log.info("ldt:{}", ldt);

        log.info("atZone ldt:{}", ldt.atZone(ZoneId.of("Asia/Shanghai")));
        log.info("ztOffset ldt:{}", ldt.atOffset(ZoneOffset.ofHours(+8)));
        log.info("ldt:{}", ldt.minusHours(8));

    }

}
