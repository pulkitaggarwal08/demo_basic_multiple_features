package com.innovative.housingsecurity.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.innovative.housingsecurity.R;
import com.innovative.housingsecurity.ui.activities.ScanActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardFragment extends Fragment {

    @BindView(R.id.btn_share_link)
    Button btnSharLlink;
    @BindView(R.id.btn_scanner)
    Button btnScanner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_share_link)
    public void onClickBtnShareLink() {

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

    @OnClick(R.id.btn_scanner)
    public void onClickBtnScanner() {

        Intent intent = new Intent(getContext(), ScanActivity.class);
        startActivity(intent);
    }


}
