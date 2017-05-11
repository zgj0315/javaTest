package org.after90.someTest.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zhaogj on 11/05/2017.
 */
@Service
@Slf4j
public class FlatJsonService {
    private JSONObject output = new JSONObject();
    private String strTopKey = "";

    //只展开第一层的数据，后续的不展开
    public void flatNTI() {
        String strJson = "{\n" +
                "        \"update_time\" : \"2016-07-06T17:03:37\",\n" +
                "        \"country\" : \"Ukraine\",\n" +
                "        \"services\" : [ {\n" +
                "          \"apps\" : [ ],\n" +
                "          \"layer\" : {\n" +
                "            \"application\" : {\n" +
                "              \"protocol\" : \"protocol01\"\n" +
                "            },\n" +
                "            \"transport\" : {\n" +
                "              \"protocol\" : \"protocol02\",\n" +
                "              \"port\" : \"1900\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"banner\" : \"HTTP/1.1 100 OK\",\n" +
                "          \"update_time\" : \"2016-05-01T08:50:17\"\n" +
                "        }, {\n" +
                "          \"banner\" : \"HTTP/1.1 200 OK\",\n" +
                "          \"update_time\" : \"2016-07-06T17:03:37\",\n" +
                "          \"apps\" : [{\"product\":\"php\"},{\"product\":\"asp\"} ],\n" +
                "          \"layer\" : {\n" +
                "            \"application\" : {\n" +
                "              \"protocol\" : \"protocol11\"\n" +
                "            },\n" +
                "            \"transport\" : {\n" +
                "              \"protocol\" : \"protocol12\",\n" +
                "              \"port\" : 32768\n" +
                "            }\n" +
                "          }\n" +
                "        } ],\n" +
                "        \"location\" : \"50.45465850830078,30.523799896240234\",\n" +
                "        \"country_code\" : \"UA\",\n" +
                "        \"created_time\" : \"2016-07-06T17:03:37\"\n" +
                "      }";
        //log.info("strJson:{}", strJson);
        JSONObject object = JSONObject.parseObject(strJson);
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            String strKey = entry.getKey();
            Object value = entry.getValue();
            strTopKey = strKey;
            if ("com.alibaba.fastjson.JSONArray".equals(value.getClass().getName())) {
                log.info("展开数组:{}", strKey);
                //log.info("展开结果:{}",readArrObject(strKey, (JSONArray) value));
                output.put(strKey, readArrObject((JSONArray) value));
            } else if ("com.alibaba.fastjson.JSONObject".equals(value.getClass().getName())) {
                log.info("展开Object:{}", strKey);
                output.put(strKey, readObject(strKey, (JSONObject) value));
            } else {
                log.info("最外层原样输出key:{}, value:{}", strKey, value);
                //不操作，保持原样
                output.put(strKey, value);
            }
        }
        log.info("output:{}", output);
    }


    //strTopKey，最外层的key
    private JSONArray readArrObject(JSONArray jsonList) {
        //来开始折腾
        JSONArray jsons = (JSONArray) output.get(strTopKey);
        if (jsons == null) {
            jsons = new JSONArray();
        }
        for (Object object : jsonList) {
            jsons.add(readObject("", (JSONObject) object));
        }
        return jsons;
    }

    //这里是重点
    private JSONObject readObject(String strPrefix, JSONObject object) {
        JSONObject objectTmp = new JSONObject();
        log.info("strPrefix:{}", strPrefix);
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            log.info("strKey:{}", entry.getKey());
            String strKey = entry.getKey();
            Object value = entry.getValue();
            if ("com.alibaba.fastjson.JSONArray".equals(value.getClass().getName())) {
                log.info("非外层数组不展开:{}", strKey);
                objectTmp.put(("".equals(strPrefix) ? "" : strPrefix + "-") + strKey, value);
            } else if ("com.alibaba.fastjson.JSONObject".equals(value.getClass().getName())) {
                log.info("展开Object:{}", strKey);
                objectTmp.putAll(readObject(("".equals(strPrefix) ? "" : strPrefix + "-") + strKey, (JSONObject) value));
            } else {
                log.info("最外层原样输出key:{}, value:{}", strKey, value);
                //不操作，保持原样
                objectTmp.put(("".equals(strPrefix) ? "" : strPrefix + "-") + strKey, value);
            }
        }
        return objectTmp;
    }

}
