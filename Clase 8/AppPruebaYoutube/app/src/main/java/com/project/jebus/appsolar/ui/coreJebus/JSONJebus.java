package com.project.jebus.appsolar.ui.coreJebus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by jebus on 01/01/2015.
 */
public class JSONJebus {

    public static JSONObject generateJSONObject(Object obj)
    {
        Gson gson = new Gson();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(gson.toJson(obj));//JsonObject(gson.toJson(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static Object jsonToObject(JSONObject jsonObject, Class<?> objectClass)
    {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        Object nObj = gson.fromJson(jsonObject.toString(), objectClass);

        return nObj;
    }

    public static Object jsonStringToObject(String jsonString, Class<?> objectClass)
    {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        Object nObj = gson.fromJson(jsonString, objectClass);

        return nObj;
    }
}
