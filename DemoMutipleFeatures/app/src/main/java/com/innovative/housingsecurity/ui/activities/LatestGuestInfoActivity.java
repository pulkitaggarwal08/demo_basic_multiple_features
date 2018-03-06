package com.innovative.housingsecurity.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.innovative.housingsecurity.R;
import com.innovative.housingsecurity.api.volley.CustomJsonObjectRequest;
import com.innovative.housingsecurity.config.App;
import com.innovative.housingsecurity.config.AppConstant;
import com.innovative.housingsecurity.utils.CommonUtils;
import com.innovative.housingsecurity.utils.RequestParameterUtil;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LatestGuestInfoActivity extends AppCompatActivity {

    @BindView(R.id.btn_approved)
    Button btnApproved;
    @BindView(R.id.btn_decline)
    Button btnDecline;
    @BindView(R.id.iv_image)
    ImageView ivImage;

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_guest_info);

        activity = this;
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_approved)
    public void onClickbtnApproved() {

        //Todo: show data here
        btn_share_data();
    }

    private void btn_share_data() {

        String shareBody = "Here is the share content body";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject here");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(shareIntent, "Share Data"));
    }

    @OnClick(R.id.btn_decline)
    public void onClickbtnDecline() {

        declineRequest();
    }

    private void declineRequest() {
        //Todo: get correct data
        String item_id = getIntent().getStringExtra("item_id");

        if (!item_id.equalsIgnoreCase("") && !item_id.equalsIgnoreCase(null)) {

            CommonUtils.showProgressDilaog(activity);

            JSONObject scannedDataObject = RequestParameterUtil.getScannedObject(item_id);

            CustomJsonObjectRequest customJsonObjectRequest = new CustomJsonObjectRequest(Request.Method.POST,
                    AppConstant.BASE_URL + AppConstant.GUEST_INFO, scannedDataObject,
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
                    error.printStackTrace();
                }
            });
            App.getRequestQueue().add(customJsonObjectRequest);
        }
    }

}
