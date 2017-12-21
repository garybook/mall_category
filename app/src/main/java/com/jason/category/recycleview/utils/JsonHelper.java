package com.jason.category.recycleview.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by vincent on 2015/9/10.
 */
public class JsonHelper {


    public static String toJSONString(Object object) {

        Gson gson =new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(object);
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        Gson gson =new GsonBuilder().disableHtmlEscaping().create();
        return gson.fromJson(text, clazz);
    }

//    public static <T> T parseObject(String text, Class<T> clazz) {
//        return JSON.parseObject(text, clazz);
//    }
//
//    public static <T> T parseObject(String text, Type type) {
//        return JSON.parseObject(text, type);
//    }


}
