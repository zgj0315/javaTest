package org.after90.someTest.map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.hash;

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

    public void doHash() {
        for (int i = 0; i < 5; i++) {
            log.info("routing:{}, hash:{}, shard_num{}", i, hash("" + i), hash("" + i) % 5);

        }
    }

    public void readMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("age", 25);
        map.put("name", "zhaogj");
        Map<String, Object> car = new HashMap<String, Object>();
        car.put("bmw", "535Li");
        car.put("bmw", "740Li");
        map.put("car", car);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String strKey = entry.getKey();
            Object value = entry.getValue();
            log.info("strKey:{},value.class:{}", strKey, value.getClass().getName());
        }
    }
}
