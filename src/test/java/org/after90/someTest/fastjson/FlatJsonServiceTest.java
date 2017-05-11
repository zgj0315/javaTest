package test.org.after90.someTest.fastjson;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.someTest.fastjson.FlatJsonService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FlatJsonService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>May 11, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class FlatJsonServiceTest {
    @Autowired
    private FlatJsonService flat;

    @Test
    public void testFlatNTI() throws Exception {
        flat.flatNTI();
    }


} 
