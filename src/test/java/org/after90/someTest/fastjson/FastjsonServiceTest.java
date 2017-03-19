package test.org.after90.someTest.fastjson;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.someTest.fastjson.FastjsonService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FastjsonService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Mar 19, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class FastjsonServiceTest {
    @Autowired
    private FastjsonService fastjson;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: json2string()
     */
    @Test
    public void testJson2string() throws Exception {
        fastjson.json2string();
    }


} 
