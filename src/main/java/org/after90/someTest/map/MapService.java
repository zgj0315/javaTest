package org.after90.someTest.map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaogj on 28/04/2017.
 */
@Service
@Slf4j
public class MapService {
    public void doSomeTest() {
        Map<String, Integer> hashCount = new HashMap<String, Integer>();
        int nCount = hashCount.get("");

        log.info("count:{}", hashCount.get(""));
    }
}
