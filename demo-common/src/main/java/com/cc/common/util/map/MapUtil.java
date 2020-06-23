package com.cc.common.util.map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cc.common.util.ObjectUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/4 10:26
 * Description: Map工具类
 */
public class MapUtil {

    /** 默认初始大小 */
    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    /** 默认增长因子，当Map的size达到 容量*增长因子时，开始扩充Map */
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * Map是否为空
     *
     * @param map 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * Map是否为非空
     *
     * @param map 集合
     * @return 是否为非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return null != map && false == map.isEmpty();
    }


    /**
     * json对象转为Map<String, String[]>
     * @param jsonObject
     * @return
     */
    public static Map<String, String[]> convertMap(JSONObject jsonObject){
        Map<String, String[]> dataMap = null;
        if(ObjectUtil.isNotEmpty(jsonObject)){
            dataMap = new HashMap<>();
            for(String key : jsonObject.keySet()){
                String[] val = null;
                Object value = jsonObject.get(key);
                if(value instanceof JSONArray){
                    JSONArray array = (JSONArray) value;
                    val = new String[array.size()];
                    for(int i = 0; i< array.size(); i++){
                       val[i] = String.valueOf(array.get(i));
                    }
                }else{
                    val = new String[1];
                    val[0] = String.valueOf(value);
                }
                dataMap.put(key, val);
            }
        }
        return dataMap;
    }
}
