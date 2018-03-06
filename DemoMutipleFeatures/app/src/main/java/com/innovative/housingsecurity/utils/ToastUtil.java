package com.innovative.housingsecurity.utils;

import android.widget.Toast;

import com.innovative.housingsecurity.config.App;

/**
 * Created by pulki on 17-Dec-17.
 */

public class ToastUtil {
    public static void showToast(String message){
        Toast.makeText(App.getAppContext(), message, Toast.LENGTH_SHORT).show();
    }
}
