package com.fangye.dataparser.utils;

import android.os.Looper;
import android.util.Log;

/**
 * Description:  数据解析log 输出工具类
 *
 * @ProjectName: LibraryCollection
 * @Package: com.ekwing.dataparser
 * @Author: shijiaxiong@moyi365.com
 * @UpdateDate: 2020/3/30 16:53
 */
public class LogTagsUtils {

    private static boolean mLogLevel = false;
    private static String TAG = "dataparser";

    public static boolean getmLogLevel() {
        return mLogLevel;
    }

    public static void setLogLevel(boolean level) {
        mLogLevel = level;
    }

    public static void v(String msg) {
        if (mLogLevel) {
            Log.v(TAG, isMainThread()+msg);
        }
    }

    public static void d(String msg) {
        if (mLogLevel) {
            Log.d(TAG, isMainThread()+msg);
        }
    }

    public static void i(String msg) {
        if (mLogLevel) {
            Log.i(TAG, isMainThread()+msg);
        }
    }

    public static void w( String msg) {
        if (mLogLevel) {
            Log.w(TAG, isMainThread()+msg);
        }
    }

    public static void e( String msg) {
        if (mLogLevel) {
            Log.e(TAG, isMainThread()+msg);
        }
    }

    public static String isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper() ? "主线程-" : "子线程-";
    }

}
