package org.after90.someTest.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.stream.JsonReader;

/**
 * Created by zhaogj on 19/03/2017.
 */
@Service
@Slf4j
public class FastjsonService {
    public void json2string() {
        Group group = new Group();
        group.setNId(0);
        group.setStrName("admin");

        User guestUser = new User();
        guestUser.setNId(2);
        guestUser.setStrName("guest");

        User rootUser = new User();
        rootUser.setNId(3);
        rootUser.setStrName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group);

        log.info(jsonString);
    }

    //展开Object
    public void faltObject() {
        String strJson = "{\"country_code\":\"VN\",\"country\":\"Viet Nam\",\"created_time\":\"2016-07-06T19:54:56\",\"update_time\":\"2016-07-06T19:54:56\",\"province\":\"Dak Lak\",\"city\":\"Hanoi\",\"ip\":\"116.97.63.61\",\"data_type\n" +
                "\":\"ip\",\"location\":\"21.024499893188477,105.84117126464844\",\"services\":[{\"update_time\":\"2016-07-06T19:54:56\",\"banner\":\"RTSP/1.0 200 OK\\r\\nServer: H264DVR 1.0\\r\\nCseq: 1\\r\\nPublic: OPT\n" +
                "IONS, DESCRIBE, SETUP, TEARDOWN, GET_PARAMETER, PLAY, PAUSE\\r\\n\\r\\n\",\"layer\":{\"application\":{\"protocol\":\"RTSP\",\"version\":\"1.0\"},\"transport\":{\"protocol\":\"TCP\",\"port\":554}},\"apps\":[]}\n" +
                "],\"_id\":\"1952530237\"}";
        log.info("strJson:{}", strJson);
        JSONObject object = JSONObject.parseObject(strJson);
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            Field[] aField = entry.getValue().getClass().getDeclaredFields();
            for (Field field : aField) {
                //field.setAccessible(true);
                String strName = field.getName();
                String strType = field.getGenericType().toString();
                log.info("name:{}, type:{}", strName, strType);
            }
        }
//        Field[] aField = object.getClass().getDeclaredFields();
//        for (Field field : aField) {
//            //field.setAccessible(true);
//            String strName = field.getName();
//            String strType = field.getGenericType().toString();
//            log.info("name:{}, type:{}", strName, strType);
//            if ("java.util.Map<java.lang.String, java.lang.Object>".equals(strType)) {
//                Method m = object.getClass().getm//.getMethod("get"+strName);
//
//            }
//            if ("map".equals(strName)) {
//                Field[] aFieldMap = field.getGenericType().getClass().getDeclaredFields();
//                for (Field fieldMap : aFieldMap) {
//                    fieldMap.setAccessible(true);
//                    log.info("name:{}, type:{}", fieldMap.getName(), fieldMap.getGenericType().toString());
//                }
//            }
        //}
//        Method[] aMethod = object.getClass().getMethods();
//        for (Method method : aMethod) {
//
//            String strName = method.getName();
//            log.info("name:{}", strName);
//
//        }


//        for (Map.Entry<String, Object> entry : object.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//        List<JSONObject> listService = (List<JSONObject>)object.get("services");
////        JSONArray services = (JSONArray) object.get("services");
//        for (JSONObject service : listService) {
//            log.info("service:{}", service.get("update_time"));
//        }
    }


    //展开Object
    public void fastObject() {
        String strJson = "{\"country_code\":\"VN\",\"country\":\"Viet Nam\",\"created_time\":\"2016-07-06T19:54:56\",\"update_time\":\"2016-07-06T19:54:56\",\"province\":\"Dak Lak\",\"city\":\"Hanoi\",\"ip\":\"116.97.63.61\",\"data_type\n" +
                "\":\"ip\",\"location\":\"21.024499893188477,105.84117126464844\",\"services\":[{\"update_time\":\"2016-07-06T19:54:56\",\"banner\":\"RTSP/1.0 200 OK\\r\\nServer: H264DVR 1.0\\r\\nCseq: 1\\r\\nPublic: OPT\n" +
                "IONS, DESCRIBE, SETUP, TEARDOWN, GET_PARAMETER, PLAY, PAUSE\\r\\n\\r\\n\",\"layer\":{\"application\":{\"protocol\":\"RTSP\",\"version\":\"1.0\"},\"transport\":{\"protocol\":\"TCP\",\"port\":554}},\"apps\":[]}\n" +
                "],\"_id\":\"1952530237\"}";
        //log.info("strJson:{}", strJson);
        JSONObject object = JSONObject.parseObject(strJson);
        doFlat("", object);
    }

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
                log.info("strkey:{}", strKey);
                readArrObject(strKey, (JSONArray) value);
            } else if ("com.alibaba.fastjson.JSONObject".equals(value.getClass().getName())) {
                log.info("strkey:{}", strKey);
                readObject(strKey, (JSONObject) entry.getValue());
            } else {
                //不操作，保持原样
                output.put(strKey, value);
                log.info("key:{}, value:{}", strKey, value);
            }
        }
        log.info("output:{}", output);
    }


    private void doFlat(String strPrefix, JSONObject object) {
        JSONObject objectTmp = new JSONObject();
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            String strKey = entry.getKey();
            Object value = entry.getValue();
            log.info("strTopKey:{}", strTopKey);
            if ("com.alibaba.fastjson.JSONArray".equals(value.getClass().getName())) {
                log.info("strKey:{}", strKey);
                //不展开数组，直接输出
                //readArrObject(strPrefix + ("".equals(strPrefix) ? "" : "-") + strKey, (JSONArray) value);
                objectTmp.put(strPrefix + ("".equals(strPrefix) ? "" : "-") + strKey, value);
            } else if ("com.alibaba.fastjson.JSONObject".equals(value.getClass().getName())) {
                log.info("strKey:{}", strKey);
                readObject(strPrefix + ("".equals(strPrefix) ? "" : "-") + strKey, (JSONObject) value);
            } else {
                objectTmp.put(strPrefix + ("".equals(strPrefix) ? "" : "-") + strKey, value);
                log.info("key:{}, value:{}", strPrefix + ("".equals(strPrefix) ? "" : "-") + strKey, value);
            }
        }
    }

    //strTopKey，最外层的key
    private void readArrObject(String strPrefix, JSONArray jsonList) {
        //来开始折腾
        JSONArray jsons = (JSONArray) output.get(strTopKey);
        if (jsons == null) {
            jsons = new JSONArray();
        }
        for (Object object : jsonList) {
            log.info("strPrefix:{}", strPrefix);
            doFlat(strPrefix, (JSONObject) object);
        }
        output.put(strTopKey, jsons);
    }

    private void readObject(String strPrefix, JSONObject object) {
        log.info("strPrefix:{}", strPrefix);
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            log.info("strKey:{}", entry.getKey());
            doFlat(strPrefix + ("".equals(strPrefix) ? "" : "-") + entry.getKey(), (JSONObject) entry.getValue());
        }
    }

}
