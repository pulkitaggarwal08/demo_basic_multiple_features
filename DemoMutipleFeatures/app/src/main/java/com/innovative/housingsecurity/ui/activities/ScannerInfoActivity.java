package com.innovative.housingsecurity.ui.activities;

import android.app.Activity;
import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.innovative.housingsecurity.R;
import com.innovative.housingsecurity.api.volley.CustomJsonObjectRequest;
import com.innovative.housingsecurity.config.ApiConstant;
import com.innovative.housingsecurity.config.App;
import com.innovative.housingsecurity.config.AppConstant;
import com.innovative.housingsecurity.utils.CommonUtils;
import com.innovative.housingsecurity.utils.RequestParameterUtil;
import com.innovative.housingsecurity.utils.SnackbarUtil;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScannerInfoActivity extends AppCompatActivity {

    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_name)
    ImageView tvName;
    @BindView(R.id.tv_address)
    ImageView tvAddress;

    @BindView(R.id.iv_visitor_image)
    ImageView ivVisitorImage;
    @BindView(R.id.tv_visitor_name)
    ImageView tvVisitorName;
    @BindView(R.id.tv_total_guests)
    ImageView tvTotalGuests;

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_info);

        activity = this;
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        String item_id = getIntent().getStringExtra("item_id");

        if (!item_id.equalsIgnoreCase("") && !item_id.equalsIgnoreCase(null)) {

            CommonUtils.showProgressDilaog(activity);

            JSONObject scannedDataObject = RequestParameterUtil.getScannedObject(item_id);

            CustomJsonObjectRequest customJsonObjectRequest = new CustomJsonObjectRequest(Request.Method.POST,
                    AppConstant.BASE_URL + AppConstant.SCANNED_URL, scannedDataObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            CommonUtils.dismissProgressDilaog();

                            //Todo: get Data here


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    CommonUtils.dismissProgressDilaog();
                    SnackbarUtil.showErrorShortSnackbar(ivImage, "Not Success");
                }
            });
            App.getRequestQueue().add(customJsonObjectRequest);
        }

    }


}
