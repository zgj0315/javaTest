package org.after90.someTest.buffer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhaogj on 14/07/2017.
 */
@Service
@Slf4j
public class LinkedBlockingQueueService {
    private LinkedBlockingQueue<String> lbqBuffer = new LinkedBlockingQueue<String>();

    public void writer(int nNum) {
        for (int i = 0; i < 10000; i++) {
            lbqBuffer.add("num:" + nNum + "," + i + "," + Math.random());
        }
    }

    public void reader() {
        while (true) {
            String strTmp = null;
            try {
                strTmp = lbqBuffer.take();
            } catch (Exception e) {
                log.error("", e);
            }
            log.info("strTmp:{}", strTmp);
        }
    }
}
