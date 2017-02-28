package test.org.after90.service;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.service.DataFromKafkaService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DataFromKafkaService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 28, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class DataFromKafkaServiceTest {
    @Autowired
    private DataFromKafkaService dataFromKafka;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: dataFromKafka()
     */
    @Test
    public void testDataFromKafka() throws Exception {
        dataFromKafka.dataFromKafka();
    }


} 
