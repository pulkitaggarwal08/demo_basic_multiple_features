package com.innovative.housingsecurity.utils;

import android.text.TextUtils;

/**
 * Created by pulkit on 27/12/17.
 */

public class StringUtils {

    public static boolean isEmpty(String data) {
        if (TextUtils.isEmpty(data)) {
            return true;
        }
        return false;
    }
}
