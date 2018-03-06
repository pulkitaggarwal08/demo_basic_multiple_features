package com.innovative.housingsecurity.ui.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

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

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.ed_first_name)
    EditText edFirstName;
    @BindView(R.id.ed_last_name)
    EditText edLastName;
    @BindView(R.id.ed_email)
    EditText edEmail;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_password)
    EditText edPassword;
    @BindView(R.id.ed_flat_no)
    EditText edFlatNumber;
    @BindView(R.id.ed_floor_no)
    EditText edFloorNumber;
    @BindView(R.id.ed_block)
    EditText edBlock;
    @BindView(R.id.ed_society_name)
    EditText edSocietyName;
    @BindView(R.id.ed_society_address)
    EditText edSocietyAddress;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.tv_new_account)
    TextView tvNewAccount;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    private String firstName, lastName, email, phone, password, flatNumber, floorNumber, block, societyName, societyAddress;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        activity = this;
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_submit)
    public void onClickSubmit() {
        firstName = edFirstName.getText().toString();
        lastName = edLastName.getText().toString();
        email = edEmail.getText().toString();
        phone = edPhone.getText().toString();
        password = edPassword.getText().toString();
        flatNumber = edFlatNumber.getText().toString();
        floorNumber = edFloorNumber.getText().toString();
        block = edBlock.getText().toString();
        societyName = edSocietyName.getText().toString();
        societyAddress = edSocietyAddress.getText().toString();

        if (validate()) {
            CommonUtils.showProgressDilaog(activity);

            JSONObject registrationDataObject = RequestParameterUtil.getRegisterObject(firstName + " " + lastName,
                    email, phone, password, flatNumber, floorNumber, block, societyName, societyAddress);

            CustomJsonObjectRequest customJsonObjectRequest = new CustomJsonObjectRequest(Request.Method.POST,
                    AppConstant.BASE_URL + AppConstant.REGISTER_URL, registrationDataObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            CommonUtils.dismissProgressDilaog();
                            if (response != null) {
                                try {
                                    SnackbarUtil.showSuccessShortSnackbar(findViewById(android.R.id.content),
                                            ((JSONObject) response.get("data")).getString("message"));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    CommonUtils.dismissProgressDilaog();
                    SnackbarUtil.showErrorShortSnackbar(scrollView, "Register not Success");
                }
            });
            App.getRequestQueue().add(customJsonObjectRequest);
        }
    }

    private boolean validate() {

        if (StringUtils.isEmpty(firstName)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_first_name));
            return false;
        } else if (StringUtils.isEmpty(lastName)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_last_name));
            return false;
        } else if (StringUtils.isEmpty(email)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_email));
            return false;
        } else if (StringUtils.isEmpty(phone)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_phone));
            return false;
        } else if (phone.length() < 10) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.valid_phone));
            return false;
        } else if (StringUtils.isEmpty(password)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_password));
            return false;
        } else if (StringUtils.isEmpty(flatNumber)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_flat));
            return false;
        } else if (StringUtils.isEmpty(floorNumber)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_floor_Number));
            return false;
        } else if (StringUtils.isEmpty(block)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_block));
            return false;
        } else if (StringUtils.isEmpty(societyName)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_society_name));
            return false;
        } else if (StringUtils.isEmpty(societyAddress)) {
            SnackbarUtil.showWarningShortSnackbar(scrollView, getMessage(R.string.empty_society_address));
            return false;
        }


        return true;
    }

    private String getMessage(int id) {
        return getResources().getString(id);
    }

    @OnClick(R.id.tv_new_account)
    public void onClickNewAccount() {
        finish();
    }

}
