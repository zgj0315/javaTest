package org.after90.someTest.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;

/**
 * Created by zhaogj on 08/07/2017.
 * JSON字符串中重复的部分去掉
 */
@Slf4j
@Service
public class DeduplicationService {
    public JSONObject cleanJSONObject(JSONObject json) {
        //log.info("json:{}", json.toString());
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            String strKey = entry.getKey();
            Object objValue = entry.getValue();
            //log.info("strKey:{},value class:{}", strKey, objValue.getClass().getSimpleName());
            //只分析数据的情况
            String strClass = objValue.getClass().getSimpleName();
            if ("JSONArray".equals(strClass)) {
                objValue = cleanJSONArray((JSONArray) objValue);
            } else if ("JSONObject".equals(strClass)) {
                objValue = cleanJSONObject((JSONObject) objValue);
            }
        }
        return json;
    }

    public JSONArray cleanJSONArray(JSONArray jsonArray) {
        HashSet hashSet = new HashSet(jsonArray);
        jsonArray.clear();
        jsonArray.addAll(hashSet);
        for (Object obj : jsonArray) {
            String strClass = obj.getClass().getSimpleName();
            if ("JSONArray".equals(strClass)) {
                obj = cleanJSONArray((JSONArray) obj);
            } else if ("JSONObject".equals(strClass)) {
                obj = cleanJSONObject((JSONObject) obj);
            }
        }
        return jsonArray;
    }

}
