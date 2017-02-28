package test.org.after90.service;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.service.KafkaService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * KafkaService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 28, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class KafkaServiceTest {
    @Autowired
    private KafkaService kafka;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: kafkaProducerDemo()
     */
    @Test
    public void testKafkaProducerDemo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: kafkaConsumerAutomaticOffsetCommittingDemo()
     */
    @Test
    public void testKafkaConsumerAutomaticOffsetCommittingDemo() throws Exception {
        kafka.kafkaConsumerAutomaticOffsetCommittingDemo();
    }

    /**
     * Method: kafkaConsumerManualOffsetControlDemo()
     */
    @Test
    public void testKafkaConsumerManualOffsetControlDemo() throws Exception {
//TODO: Test goes here... 
    }


} 
