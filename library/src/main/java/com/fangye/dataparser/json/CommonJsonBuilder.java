package com.fangye.dataparser.json;


import com.fangye.dataparser.json.gson.CollectionTypeAdapterFactory;
import com.fangye.dataparser.json.gson.GsonTypeAdapterTools;
import com.fangye.dataparser.json.gson.MapTypeAdapterFactory;
import com.fangye.dataparser.json.gson.ReflectiveTypeAdapterFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;

import org.json.JSONException;

import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 作者: shijiaxiong
 * 时间: 2019/9/26
 * 邮箱: fanyeren51@gmail.com
 * 功能:
 * <p>
 * 1）CommonJsonBuilder.newGson()得到Gson对象
 * 2）然后使用相对应的gson方法即可
 * 3）同时提供了三个方法 toObject 和toObjectArray/toArraysList ，将字符串转成Object 和 array
 * <p>
 * 解决:
 * 1)要{}后端给了 []、空字符串、字符串、数字（Number）, 均返回null ,不会崩溃，使用时需要判空，否则会崩溃,
 * 传入非标准json格式、传入html的格式或其它非json格式，会直接报异常  JsonSyntaxException
 * <p>
 * 2）要map对象 ,后端给了[]、空字符串、字符串、boolean、数字（Number），均返回null ,不会崩溃，使用时需要判空，否则会崩溃
 * <p>
 * 3)要[]后端给了 {}、空字符串、字符串、数字（Number），均返回null ,不会崩溃，使用时需要判空，否则会崩溃
 *  3.1、传入非标准json格式、传入html的格式或其它非json格式，不会报异常，会直接返回null,使用时判空
 *  3.2、toArraysList，如果数据格式不是[]，会报异常，使用时请关注
 * <p>
 * 4)要int.class, Integer.class,short.class, Short.class,long.class, Long.class,double.class, Double.class,
 * float.class, Float.class 等情况
 * 4.1 后端给的非数字类型，如空字符串、字符串、boolean、array、object 等，解析返回0;
 * 4.2给的数据 超过 实际类型 的取值范围，如定义int ，值不能超过 2147483647 ，超过解析返回0 ，所以定义类型时一定考虑数据的取值范围;
 * 4.3要int/short/long，服务端给的float/double ，解析返回0，所以服务端经的数据可能为浮点类型时，最好使用float或者double
 * <p>
 * 5)要String
 * 5.1，如果后端给了[]、{},则返回""
 * 5.2，如果后端给的[]或者{}里面有数据，会解析返回实际的字符串，返回的字符串会被转义
 * 5.3，如果后端给了基本数据类型或者boolean类型，则会将其转成String类型
 * 5.4，其它给什么类型，解析返回对应的字符串，如服务端给空字符串，解析返回为空字符串
 * <p>
 * 6)、要boolean,服务端给byte/int/short/long/float/double/array/object/字符串，解析返回false
 * <p>
 * 7). 要byte/short/int/long/boolean/float/double/String/map/object/array ,server端给返回null/字符串null的情况
 * 7.1，基本数据和String类型，解析成默认类型
 * 7.2，map/object/array类型，解析成null
 * 8)目前已知的三种崩溃情况
 * 8.1，传入xml  CommonJsonBuilder
 * 8.2，传入一个字符串
 * 8.3，传入一个错误的json
 *
 */
public class CommonJsonBuilder {


    private static Gson create() {
        return CommonJsonBuilder.GsonHolder.gson;
    }

    private static class GsonHolder {
        private static Gson gson = newGson();
    }

    /**
     * 生成注册自定义的对象处理器与集合处理器的Gson，方法
     */
    private static Gson newGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Class builder = (Class) gsonBuilder.getClass();
        Field f = null;
        try {
            //通过反射得到构造器
            f = builder.getDeclaredField("instanceCreators");
            f.setAccessible(true);
            final Map<Type, InstanceCreator<?>> val = (Map<Type, InstanceCreator<?>>) f.get(gsonBuilder);//得到此属性的值

            //注册Char类型处理器
            // gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(char.class, Character.class, GsonUtils.charTypeAdapter()));
            //注册int.class, Integer.class处理器
            gsonBuilder.registerTypeAdapterFactory(
                    TypeAdapters.newFactory(byte.class, Byte.class, GsonTypeAdapterTools.longAdapter(GsonTypeAdapterTools.GSON_TYPE_BYTE)));
            //注册short.class, Short.class处理器
            gsonBuilder.registerTypeAdapterFactory(
                    TypeAdapters.newFactory(short.class, Short.class, GsonTypeAdapterTools.longAdapter(GsonTypeAdapterTools.GSON_TYPE_SHORT)));
            //注册int.class, Integer.class处理器
            gsonBuilder.registerTypeAdapterFactory(
                    TypeAdapters.newFactory(int.class, Integer.class, GsonTypeAdapterTools.longAdapter(GsonTypeAdapterTools.GSON_TYPE_INT)));
            //注册long.class, Long.class处理器
            gsonBuilder.registerTypeAdapterFactory(
                    TypeAdapters.newFactory(long.class, Long.class, GsonTypeAdapterTools.longAdapter(GsonTypeAdapterTools.GSON_TYPE_LONG)));
            //注册float.class, Float.class处理器
            gsonBuilder.registerTypeAdapterFactory(
                    TypeAdapters.newFactory(float.class, Float.class, GsonTypeAdapterTools.longAdapter(GsonTypeAdapterTools.GSON_TYPE_FLOAT)));
            //注册double.class, Double.class处理器
            gsonBuilder.registerTypeAdapterFactory(
                    TypeAdapters.newFactory(double.class, Double.class, GsonTypeAdapterTools.longAdapter(GsonTypeAdapterTools.GSON_TYPE_DOUBLE)));
            //注册boolean.class,Boolean.class处理器
            gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(boolean.class, Boolean.class, GsonTypeAdapterTools.booleanTypeAdapter()));
            //注册String类型处理器
            gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(String.class, GsonTypeAdapterTools.stringTypeAdapter()));
            //注册反射object的处理器
            gsonBuilder.registerTypeAdapterFactory(
                    new ReflectiveTypeAdapterFactory(new ConstructorConstructor(val), FieldNamingPolicy.IDENTITY, Excluder.DEFAULT));
            //注册集合Array的处理器
            gsonBuilder.registerTypeAdapterFactory(new CollectionTypeAdapterFactory(new ConstructorConstructor(val)));
            //注册Map 处理器
            //支持Map的key为复杂对象的形式 ，如：Map<Point, String> map = new LinkedHashMap<Point, String>();
            gsonBuilder.registerTypeAdapterFactory(new MapTypeAdapterFactory(new ConstructorConstructor(val), true));

            //支持Map的key为复杂对象的形式 ，上面一行代码已经设置过了，下面注释
            //gsonBuilder.enableComplexMapKeySerialization();
            //对json结果格式化.
            gsonBuilder.setPrettyPrinting();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gsonBuilder.create();
    }

    public static <T> T fromJson(String json, Class<T> type) throws JsonIOException, JsonSyntaxException {
        return create().fromJson(json, type);
    }

    /**
     * @param json 待解析的json
     * @param type Type type = new TypeToken<Map<String, Point>>() { }.getType())
     * @param <T> 类型
     * Map<String, Point> retMap = create().fromJson(s2,type);
     * for (String key : retMap.keySet()) {
     * System.out.println("key:" + key + " values:" + retMap.get(key));
     * }
     * @return
     */
    public static <T> T fromJson(String json, Type type) {
        return create().fromJson(json, type);
    }

    public static <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return create().fromJson(reader, typeOfT);
    }

    public static <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        return create().fromJson(json, classOfT);
    }

    public static <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return create().fromJson(json, typeOfT);
    }


    /**
     * 此方式返回List
     * 转换时，必须在对象后面添加[]，如：toArraysList(json, Object[].class)
     * 使用时，不能直接强转为java.util.ArrayList ，需要转化，如下：
     * List<String> result = Arrays.asList(temp);
     * ArrayList<String> arrayList= new ArrayList<>(result);
     * 注意：如果数据格式不是[]，会报异常，使用时请关注
     *
     * @param json 需要解析的字符串
     * @param c 需要转换的class对象引用
     * @param <T> 需要转换的class对象
     * @return asList方法返回的是一个List，不能直接强转成ArrayList
     * 因为 java.util.Arrays.ArrayList下有一个ArrayList子类
     * 需要通过java.util.ArrayList 转换一下：
     * List<String> result = Arrays.asList(temp);
     * ArrayList<String> arrayList= new ArrayList<>(result);
     * <p>
     * 如果数据格式不是[]，会报异常，使用时请注意
     */
    public static <T> List<T> toArraysList(String json, Class<T[]> c) {
        return Arrays.asList(fromJson(json, c));
        // // 使用泛型，此种方式返回的是LinkedTreeMap,遍历得使用Iterator
        // return fromJson(json, new TypeToken<List<T>>() {}.getType());
    }


    /**
     * 此方式返回java.util.List
     * 转化 ，toObjectArray(json, Object.class)
     * 使用时，可直接强转为java.util.ArrayList
     * 注意：如果数据格式不是[]，会默认返回[],不会报异常
     *
     * @param json 需要解析的字符串
     * @param c 需要转换的class对象引用
     * @return 返回 java.util.List ,可直接强转为java.util.ArrayList
     * <p>
     * 如果数据格式不是[]，会默认返回[],不会报异常
     */
    public static <T> List<T> toObjectArray(String json, Class<T> c) {
        try {
            DataJsonArray ja = new DataJsonArray(json);
            int length = ja.length();
            List<T> ret = new ArrayList<>(length);
            for (int i = 0; i < length; ++i) {
                ret.add(toObject(ja.getString(i), c));
            }
            return ret;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
//        return new ArrayList<>();

        //        // 使用泛型，此种方式返回的是LinkedTreeMap,遍历得使用Iterator
        //        return fromJson(json, new TypeToken<List<T>>() {}.getType());
    }

    public static <T> T toObject(String json, Class<T> c) {
        return fromJson(json, c);
    }

    public static String toJson(Object src) {
        return create().toJson(src);
    }

    public static String toJson(Object src, Type typeOfSrc) {
        return create().toJson(src, typeOfSrc);
    }

}