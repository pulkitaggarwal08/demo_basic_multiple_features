package com.innovative.housingsecurity.utils;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;

/**
 * Created by pulkit on 27/12/17.
 */

public class SnackbarUtil {

    public static void showWarningShortSnackbar(View view, String message) {
        /*Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, 800);
        View view = snackbar.getView();
        view.setBackgroundColor(App.getAppContext().getResources().getColor(R.color.orange_snackbar));
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        snackbar.show();*/

        TSnackbar snackbar = TSnackbar.make(view, message, TSnackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.parseColor("#EF6C00"));
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    public static void showErrorShortSnackbar(View view, String message) {
        /*Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(App.getAppContext().getResources().getColor(R.color.red_snackbar));
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
        params.gravity = Gravity.TOP;
        snackbar.show();*/

        TSnackbar snackbar = TSnackbar.make(view, message, TSnackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.parseColor("#E53935"));
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    public static void showSuccessShortSnackbar(View view, String message) {
        /*Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(App.getAppContext().getResources().getColor(R.color.green_snackbar));
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
        params.gravity = Gravity.TOP;
        snackbar.show();*/

        TSnackbar snackbar = TSnackbar.make(view, message, TSnackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.parseColor("#43A047"));
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    public static void showSuccessLongSnackbar(View view, String message) {
        /*Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(App.getAppContext().getResources().getColor(R.color.green_snackbar));
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
        params.gravity = Gravity.TOP;
        snackbar.show();*/

        TSnackbar snackbar = TSnackbar.make(view, message, TSnackbar.LENGTH_LONG);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.parseColor("#43A047"));
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

}
