package com.innovative.housingsecurity.ui.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.innovative.housingsecurity.R;
import com.innovative.housingsecurity.api.volley.CustomJsonObjectRequest;
import com.innovative.housingsecurity.config.App;
import com.innovative.housingsecurity.config.AppConstant;
import com.innovative.housingsecurity.utils.CommonUtils;
import com.innovative.housingsecurity.utils.RequestParameterUtil;
import com.innovative.housingsecurity.utils.SnackbarUtil;
import com.innovative.housingsecurity.utils.StringUtils;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private static final long DELAY_MILLIS = 1900;

    @BindView(R.id.ed_email)
    EditText edEmail;
    @BindView(R.id.ed_password)
    EditText edPassword;
    @BindView(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    private String email, password, token, deviceId, appType;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        activity = this;
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_forgot_password)
    public void onClickForgotPassword() {

        final Dialog dialog = new Dialog(LoginActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_forgot_password);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);

        final EditText edForgotPassword = (EditText) dialog.findViewById(R.id.ed_username);
        Button btnSubmit = (Button) dialog.findViewById(R.id.btn_submit);
        Button btnCancel = (Button) dialog.findViewById(R.id.btn_cancel);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edForgotPassword.getText().toString();
                if (valiadteForgotField()) {
                    SnackbarUtil.showSuccessLongSnackbar(scrollView, getMessage(R.string.success_send_email));
                    dialog.dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @OnClick(R.id.tv_new_account)
    public void onClickRegisterUser() {

        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

    private boolean valiadteForgotField() {
        if (StringUtils.isEmpty(email)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_email));
            return false;
        }
        return true;
    }

//    @OnClick(R.id.btn_submit)
//    public void onClickSubmit(){
//
//        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//        startActivity(intent);
////        finish();
//    }

    @OnClick(R.id.btn_submit)
    public void onClickSubmit() {

        email = edEmail.getText().toString();
        password = edPassword.getText().toString();
        token = "nkjndka";
        deviceId = CommonUtils.deviceId();
        appType = "Android";

        if (validate()) {
            CommonUtils.showProgressDilaog(activity);
            JSONObject loginDataObject = RequestParameterUtil.getLoginObject(email, password, token, deviceId, appType);

            CustomJsonObjectRequest customJsonObjectRequest = new CustomJsonObjectRequest(Request.Method.POST,
                    AppConstant.BASE_URL + AppConstant.LOGIN_URL, loginDataObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    CommonUtils.dismissProgressDilaog();
                    if (response != null) {
                        try {
                            SnackbarUtil.showSuccessShortSnackbar(scrollView,
                                    ((JSONObject) response.get("data")).getString("message"));

                            if (((JSONObject) response.get("data")).getString("status").equalsIgnoreCase("1")) {

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }, DELAY_MILLIS);

                            } else {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                    }
                                }, DELAY_MILLIS);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    SnackbarUtil.showErrorShortSnackbar(scrollView, "Login not Success");
                }
            });
            App.getRequestQueue().add(customJsonObjectRequest);
        }
    }

    private boolean validate() {

        if (StringUtils.isEmpty(email)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_email));
            return false;
        } else if (StringUtils.isEmpty(password)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_password));
            return false;
        }
        return true;
    }

    private String getMessage(int id) {

        return getResources().getString(id);
    }


}
