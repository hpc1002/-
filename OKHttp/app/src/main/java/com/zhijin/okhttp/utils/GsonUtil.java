package com.zhijin.okhttp.utils;

import com.google.gson.Gson;

/**
 * Created by hpc on 2017/1/4.
 */

public class GsonUtil {
    //将Json数据解析成相应的映射对象
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }
}
