package test.org.after90.someTest.buffer;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.someTest.buffer.LinkedBlockingQueueService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class LinkedBlockingQueueServiceTest {
    @Autowired
    private LinkedBlockingQueueService buffer;

    @Test
    public void testWriter() throws Exception {
//TODO: Test goes here... 
    }

    @Test
    public void testReader() throws Exception {
//TODO: Test goes here... 
    }

    @Test
    public void testAll() throws Exception {
        for (int i = 0; i < 10; i++) {
            int j = i;
            new Thread() {
                @Override
                public void run() {
                    buffer.writer(j);
                }
            }.start();
        }
        buffer.reader();
    }
} 
