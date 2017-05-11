package test.org.after90.someTest.file;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.someTest.file.FileService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FileService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>May 2, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class FileServiceTest {

    @Autowired
    private FileService file;

    @Test
    public void testReadFileList() throws Exception {
        file.readFileList();
    }


} 
