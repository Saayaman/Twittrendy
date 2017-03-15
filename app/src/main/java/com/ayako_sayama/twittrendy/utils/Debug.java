package com.ayako_sayama.twittrendy.utils;

import android.util.Log;

/**
 * Created by ayako_sayama on 2017-03-14.
 */

public class Debug {
    public static final boolean DBG = false;
    public static void Log(String value) {
        Log.e("DLog", value);
    }

    public static void Log(String value, Throwable throwable) {
        Log.e("DLog", value, throwable);
    }
}
