package test.org.after90.someTest.es;

import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.someTest.es.SQL2DSL;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SQL2DSL Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>May 23, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class SQL2DSLTest {
    @Autowired
    private SQL2DSL sql2dsl;

    @Test
    public void testSql2dsl() throws Exception {
        sql2dsl.sql2dsl();
    }


} 
