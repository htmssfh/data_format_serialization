# 数据解析工具类

[源码分析请查看](https://juejin.im/post/5eb3416c6fb9a04340658f40)

## 一、功能


### 1.1 Json解析
>  Gson解析工具库，防止服务端返回异常信息导致的崩溃问题，保证客户端正常运行,
>  Android开发主要基于Java开发（属于强类型语言），不少公司开发的语言为php(属于弱类型语言)，
>  所以经常会因为server端某些字段的数据类型与客服端这边不一致，导致json解析失败，从而引发崩溃问题，造成很不好的用户体验
>
>  主要有两个功能：
>
>   1）、当某个字段解析失败后，可跳转下一个字段继续解析，至少可保证部分功能 可以正常使用，
>   2）、某个字段解析失败后，给默认值，如果是基本数据类型，如int ，则默认值为0，boolean默认值为false,如果是array类型，默认为[],即空集合
>
>  支持解析实体、集合、Map、基本数据类型等 在 异常情况下， 处理为默认值 ，主要支持情况如下


 1. 要{},后端给了 []、空字符串、字符串、数字、boolean, 均返回实例对象{},为空对象，length为0

    1.1、传入非标准json格式、传入html的格式或其它非json格式，会直接报异常  JsonSyntaxException

 2. 要[]后端给了 {}、空字符串、字符串、数字、boolean，均返回空数组[] ，length 为0

    1.1、toObjectArray，传入非标准json格式、传入html的格式或其它非json格式，不会报异常，会直接返回[]

    1.2、toArraysList，如果数据格式不是[]，会报异常，使用时请关注

 3. 要int.class, Integer.class,short.class, Short.class,long.class, Long.class,double.class, Double.class,
    float.class, Float.class 等情况

    3.1、后端给的非数字类型，如空字符串、字符串、boolean、array、object 等，解析返回0;

    3.1、给的数据 超过 实际类型 的取值范围，如定义int ，值不能超过 2147483647 ，超过解析返回0 ，所以定义类型时一定考虑数据的取值范围;

    3.3、要int/short/long，服务端给的float/double ，解析返回0，所以服务端经的数据可能为浮点类型时，最好使用float或者double

 4. 要String

    4.1、如果后端给了[]、{},则返回""

    4.2，如果后端给了[]或者{}里面有数据，会解析返回实际的字符串

    4.3，如果后端给了基本数据类型或者boolean类型，则会将其转成String类型

 5. 要map对象 ,后端给了[]、空字符串、字符串、boolean、数字，均返回实例对象{} ,即空map集合

 6. 要boolean,服务端给byte/int/short/long/float/double/array/object/字符串，解析返回false

 7. 目前已知的三种崩溃情况

    7.1，传入xml  CommonJsonBuilder

    7.2，传入一个字符串

    7.3，传入一个错误的json


 > Gson-2.8.5

### xml解析
正开发中。。。

## 二.更新日志

### 1.0.1
1、支持boolean和byte的自定义适配
2、JsonObject和JsonArray 转义问题处理

### 1.0.0
1、初次发布远程依赖版本，支持的功能如上描述




## 三、使用

### 3.1、将JitPack存储库添加到您的构建文件中(项目根目录下build.gradle文件)
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### 3.2、添加依赖
```
dependencies {
    implementation 'com.github.fangyeren:data_format_serialization:1.0.1'
}
```



## 四、API

> 更详细的使用请查看demo

```
//LogTagsUtils.setLogLevel(true)  //打开日志输出，Loge 代表格式不对解析成默认值,
                                  //Logi输出的信息代表该格式可以正常解析到数据,没有输出肯定是正常解析到数据了

TestEntity objectAa =  CommonJsonBuilder.toObject(aa,TestEntity.class);
Log.e("dataparse","objectAa.toString()======="+CommonJsonBuilder.toJson(objectAa));

TestEntity objectBb =  CommonJsonBuilder.toObject(bb,TestEntity.class);
Log.e("dataparse","objectBb.toString()======="+CommonJsonBuilder.toJson(objectBb));

ArrayList<TestArrayBean> arrayCc = (ArrayList<TestArrayBean>) CommonJsonBuilder.toObjectArray(cc, TestArrayBean.class);
Log.e("dataparse","arrayCc.toString()======="+CommonJsonBuilder.toJson(arrayCc));

List<TestArrayBean> list =  CommonJsonBuilder.toArraysList(xml, TestArrayBean[].class);
ArrayList<TestArrayBean> arrayCc = new ArrayList<>(list);
Log.e("dataparse","arrayCc.toString()===111===="+CommonJsonBuilder.toJson(arrayCc));
```



## 五、混淆

> ```
>
> #---------------Begin: proguard configuration for Gson  ----------
> # Gson uses generic type information stored in a class file when working with fields. Proguard
> # removes such information by default, so configure it to keep all of it.
> -keepattributes Signature
>
> # For using GSON @Expose annotation
> -keepattributes *Annotation*
>
> # Gson specific classes
> -keep class sun.misc.Unsafe { *; }
> #-keep class com.google.gson.stream.** { *; }
>
> # Application classes that will be serialized/deserialized over Gson
> -keep class com.google.gson.examples.android.model.** { *; }
>
> -dontwarn com.google.gson.**
> -keep class com.google.gson.**{*;}
> ##---------------End: proguard configuration for Gson  ----------
>
>
> # 另外解析的对象需要添加不混淆代码
> ```
>
>

