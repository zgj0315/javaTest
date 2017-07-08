package test.org.after90.someTest.fastjson;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.after90.Application;
import org.after90.someTest.fastjson.DeduplicationService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DeduplicationService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jul 8, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class DeduplicationServiceTest {
    @Autowired
    private DeduplicationService d;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: doClean()
     */
    @Test
    public void testDoClean() throws Exception {
        String strJSON = "{\n" +
                "    \"user_name\":\"zhoagj\",\n" +
                "    \"age\":25,\n" +
                "    \"babys\":[\"Nini\",\"Sunshine\",\"Nini\"],\n" +
                "    \"cars\":[\n" +
                "        {\n" +
                "            \"car_name\":\"740Li\",\n" +
                "            \"price\":1400000\n" +
                "        },\n" +
                "        {\n" +
                "            \"car_name\":\"335Li\",\n" +
                "            \"price\":400000\n" +
                "        },\n" +
                "        {\n" +
                "            \"price\":400000,\n" +
                "            \"car_name\":\"335Li\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"car_name\":\"740Li\",\n" +
                "            \"price\":1400000\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject json = d.cleanJSONObject(JSONObject.parseObject(strJSON));
        log.info("json:{}", json.toString());
    }


} 
