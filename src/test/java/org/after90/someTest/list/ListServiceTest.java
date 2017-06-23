package test.org.after90.someTest.list;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.someTest.list.ListService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ListService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 16, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class ListServiceTest {
    @Autowired
    private ListService list;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: doTest()
     */
    @Test
    public void testDoTest() throws Exception {
        list.doTest();
    }


} 
