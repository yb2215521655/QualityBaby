package com.swust.question.utils.http;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.*;

/**
 * @author pang
 * @version V1.0
 * @ClassName: JsonUtil
 * @Package com.swust.question.utils.http
 * @description: json数据操作工具包
 * @date 2019/4/6 12:35
 */
public class JsonUtil {
    public static Map<String,String> json2Map(JSONObject jsonObject){
        Set<String> keySet=jsonObject.keySet();
        Map<String,String> result=new HashMap<>();
        for (String str:keySet){
            result.put(str,jsonObject.getString(str));
        }
        return result;
    }
}
