package com.innovative.housingsecurity.firebase_services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by pulkit on 29/12/17.
 */

public class AndroidFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = AndroidFirebaseInstanceIdService.class.getName();

    @Override
    public void onTokenRefresh() {
//        super.onTokenRefresh();

        Log.i(TAG, "onTokenRefresh: ");

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {


    }

}
