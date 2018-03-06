package com.innovative.housingsecurity.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;
import android.view.ViewGroup;
import android.view.Window;

import com.innovative.housingsecurity.R;
import com.innovative.housingsecurity.config.App;

/**
 * Created by pulkit on 28/12/17.
 */

public class CommonUtils {

    private static Dialog dialog;

    public static String deviceId() {
        return Settings.Secure.getString(App.getAppContext().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static void showProgressDilaog(Activity activity) {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.progress);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public static void dismissProgressDilaog() {
        dialog.dismiss();
    }
}



