package test.org.after90.someTest.gz;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.someTest.gz.GZService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GZService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 26, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class GZServiceTest {
    @Autowired
    private GZService gz;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: writeFile()
     */
    @Test
    public void testWriteFile() throws Exception {
        gz.writeFile();
    }

    /**
     * Method: readFile()
     */
    @Test
    public void testReadFile() throws Exception {
        gz.readFile();
    }


} 
