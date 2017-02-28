package test.org.after90.service;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.service.DataToKafkaService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DataToKafkaService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 28, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class DataToKafkaServiceTest {
    @Autowired
    private DataToKafkaService dataToKafka;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: dataToKafka()
     */
    @Test
    public void testDataToKafka() throws Exception {
        dataToKafka.dataToKafka();
    }


} 
