package com.capacitacion.project.appclase7.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by OSP on 16/06/17.
 */

public class JsonUtils {

    public static JSONObject generateJSONObject(Object obj) {
        Gson gson = new Gson();
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(gson.toJson(obj));
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return jsonObject;
    }

    public static Object jsonToObject(JSONObject jsonObject, Class<?> objectClass) {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        Object nObj = gson.fromJson(jsonObject.toString(), objectClass);
        return nObj;
    }

    public static Object jsonStringToObject(String jsonString, Class<?> objectClass) {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        Object nObj = gson.fromJson(jsonString, objectClass);
        return nObj;
    }

    //TODO: add
    public static <T> T jsonTo(JSONObject jsonObject, Class<T> objectClass) {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        T nObj = gson.fromJson(jsonObject.toString(), objectClass);
        return nObj;
    }

    public static <T> T stringTo(String jsonString, Class<T> objectClass) {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        T nObj = gson.fromJson(jsonString, objectClass);
        return nObj;
    }

}
