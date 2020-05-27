package com.fangye.serialization.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shoulei on 16/6/2.
 * @功能:将obj转换成json字符串.
 */
public class JsonBuilder {
    private static Gson sJsonUtils = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static String toJsonString(Object obj) {
        return sJsonUtils.toJson(obj);
    }

    public static <T> T toObject(String json, Class<T> c) {
        try {
            Log.d("dataparse","JsonBuilder=======");
            return sJsonUtils.fromJson(json, c);
        } catch (JsonSyntaxException e) {
            Log.d("dataparse","JsonBuilder======="+e.toString());
            return toObjectByReflect(json, c);
        }
    }

    public static <T> List<T> toObjectArray(String json, Class<T> c) {
        if (json == null || json.length() < 3 || json.toLowerCase().equals("null"))
            return new ArrayList<T>();

        try {
            JSONArray ja = new JSONArray(json);
            int length = ja.length();
            List<T> ret = new ArrayList<T>(length);
            for (int i = 0; i < length; ++i) {
                ret.add(toObject(ja.getString(i), c));
            }
            return ret;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList<T>();
    }

    private static <T> T toObjectByReflect(String json, Class<T> c) {
        Field[] flds = c.getDeclaredFields();
        try {
            Log.d("dataparse", "JsonBuilder===3===="+json);
            JSONObject jo = new JSONObject(json);
            T ret = c.newInstance();
            for (Field f : flds) {
                Log.d("dataparse", "JsonBuilder==3-1==="+jo.optString(f.getName()));
                if (jo.optString(f.getName()).length() > 0) {
                    Log.d("dataparse", "JsonBuilder==3-2==="+jo.optString(f.getName()));
                    f.setAccessible(true);
                    f.set(ret, transfer(jo, f.getName(), f.getType()));
                }
            }

            return ret;
        } catch (JSONException | IllegalAccessException | InstantiationException |IllegalArgumentException e) {
            Log.d("dataparse", "JsonBuilder===3-4===="+e.toString());
            return null;
        }
    }

    private static <T> T transfer(JSONObject jo, String name, Class<T> c) {
        Log.d("dataparse","JsonBuilder===4=1===");
        if (c == String.class) {
            Log.d("dataparse","JsonBuilder===4=2===");
            return (T)jo.optString(name);
        } else if (c == int.class) {
            Log.d("dataparse","JsonBuilder===4=3===");
            return (T)(Integer)jo.optInt(name);
        } else if (c == long.class) {
            Log.d("dataparse","JsonBuilder===4=4===");
            return (T)(Long)jo.optLong(name);
        } else if (c == boolean.class) {
            Log.d("dataparse","JsonBuilder===4=5===");
            return (T)(Boolean)jo.optBoolean(name);
        } else if (c == float.class) {
            Log.d("dataparse","JsonBuilder===4=6===");
            return (T)(Float)(float)jo.optDouble(name);
        } else if (c == double.class) {
            Log.d("dataparse","JsonBuilder===4=7===");
            return (T)(Double)jo.optDouble(name);
        } else {
            Log.d("dataparse", "JsonBuilder==5===");
            return toObjectByReflect(jo.optString(name), c);
        }
    }
}
