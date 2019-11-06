package com.offcn.commons;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {
    public Map<String,Object> map = new HashMap<>();

    public static ResultMap success(){
        ResultMap resultMap = new ResultMap();
        resultMap.map.put("statusCode", 200);
        resultMap.map.put("msg", "执行成功");
        return resultMap;
    }
    public static ResultMap error(){
        ResultMap resultMap = new ResultMap();
        resultMap.map.put("statusCode", 500);
        resultMap.map.put("msg", "执行失败");
        return resultMap;
    }
    public ResultMap put(String key,Object value){
        this.map.put(key, value);
        return this;
    }

}
