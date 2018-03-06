package com.innovative.housingsecurity.config;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.innovative.housingsecurity.api.volley.VolleyRequestQueue;

/**
 * Created by pulkit on 27/12/17.
 */

public class App extends Application {

    private static Context context;
    private static RequestQueue requestQueue;
    private static AppPreferences appPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        requestQueue = VolleyRequestQueue.init(context);
        appPreferences = AppPreferences.init(context);

    }

    public static Context getAppContext() {
        return context;
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static AppPreferences getAppPreferences(){
        return  appPreferences;
    }

}
