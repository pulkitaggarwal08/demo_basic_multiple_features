package com.innovative.housingsecurity.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class ScanActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler {

    private ZBarScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        mScannerView = new ZBarScannerView(this);
        setContentView(mScannerView);

    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(me.dm7.barcodescanner.zbar.Result result) {

        if (result.getContents() == null) {
            finish();

        } else {

            Log.v("GetContents: ", result.getContents());
            Log.v("GetBarcodeFormat: ", result.getBarcodeFormat().getName());

            int item_id = result.getBarcodeFormat().getId();
            String content_name = result.getBarcodeFormat().getName();
            String content_id_result = result.getContents();

            Intent intent = new Intent(this, ScannerInfoActivity.class);
            intent.putExtra("item_id", item_id);
            intent.putExtra("content_name", content_name);
            intent.putExtra("content_id_result", content_id_result);
            startActivity(intent);

        }
    }

}

