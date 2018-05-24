package com.example.asus.test.Application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        Log.e("MyApplication", "_getAppContextInvoked");
        return MyApplication.context;
    }
}
