package com.alex.androidjetpack.app.util;

import android.util.Log;

public class LogUtil {

    public static final String DEFAULT_TAG = "debug";
    public static boolean showLog = true;

    public static void v(String logText) {
        if (showLog) {
            Log.v(DEFAULT_TAG, String.valueOf(logText));
        }
    }

    public static void v(String TAG, String logText) {
        if (showLog) {
            Log.v(DEFAULT_TAG, "[" + TAG + "]" + logText);
        }
    }

    public static void d(String logText) {
        if (showLog) {
            Log.d(DEFAULT_TAG, String.valueOf(logText));
        }
    }

    public static void i(String logText) {
        if (showLog) {
            Log.i(DEFAULT_TAG, String.valueOf(logText));
        }
    }

    public static void e(String logText) {
        if (showLog) {
            Log.e(DEFAULT_TAG, String.valueOf(logText));
        }
    }

    public static void d(String TAG, String logText) {
        if (showLog) {
            Log.d(DEFAULT_TAG, "[" + TAG + "]" + logText);
        }
    }

    public static void i(String TAG, String logText) {
        if (showLog) {
            Log.i(DEFAULT_TAG, "[" + TAG + "]" + logText);
        }
    }

    public static void w(String TAG, String logText) {
        if (showLog) {
            Log.w(DEFAULT_TAG, "[" + TAG + "]" + logText);
        }
    }

    public static void w(String logText) {
        if (showLog) {
            Log.w(DEFAULT_TAG, String.valueOf(logText));
        }
    }

    public static void e(String TAG, String logText) {
        if (showLog) {
            Log.e(DEFAULT_TAG, "[" + TAG + "]" + logText);
        }
    }

    public static void d(Class c, String logText) {
        if (showLog) {
            Log.d(DEFAULT_TAG, "[" + c.getSimpleName() + "]" + logText);
        }
    }

    public static void d(Object c, String logText) {
        if (showLog) {
            Log.d(DEFAULT_TAG, "[" + c.getClass().getSimpleName() + "]"
                    + logText);
        }
    }

    /**
     * 自动测试用，方便找log
     *
     * @param TAG
     * @param logText
     */
    public static void dd(String TAG, String logText) {
        if (showLog) {
            Log.d(TAG, logText);
        }
    }

    public static void ww(String TAG, String logText) {
        if (showLog) {
            Log.w(TAG, logText);
        }
    }

    public static void ee(String TAG, String logText) {
        if (showLog) {
            Log.e(TAG, logText);
        }
    }

}
