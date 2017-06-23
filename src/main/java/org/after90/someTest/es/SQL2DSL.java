package org.after90.someTest.es;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by zhaogj on 23/05/2017.
 */
@Service
@Slf4j
public class SQL2DSL {
    public void sql2dsl() {
        String strSql = "apache and ( port:80 or port:443 ) and product:Apache";
        strSql = "port:80 and product:Apache";
        log.info("strSql: {}", strSql);


    }
}
