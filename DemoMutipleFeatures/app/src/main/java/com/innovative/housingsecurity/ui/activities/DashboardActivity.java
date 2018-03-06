package com.innovative.housingsecurity.ui.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.innovative.housingsecurity.R;
import com.innovative.housingsecurity.ui.fragments.DashboardFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity {

    private static final String TAG = DashboardActivity.class.getName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_toolbar_name)
    TextView tvToolbarName;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
//    @BindView(R.id.dashboard_container)
//    RelativeLayout dashboardContainer;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_dashboard);

        ButterKnife.bind(this);
        init();
        setupToolbar();
        initDrawer();
        setText();

    }

    private void setText() {

        //Todo: Please enter the name
//        tvToolbarName.setText("Housing security");
//        tvToolbarName.setTextColor(getResources().getColor(R.color.white));


    }

    private void init() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new DashboardFragment());
        fragmentTransaction.commit();

    }

    private void setupToolbar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initDrawer() {

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
    }

    @OnClick(R.id.dashboard_container)
    public void onClickContainers(View view) {

//        if (view.getId() == R.id.dashboard_container) {
//
//            dashboardContainer.setSelected(true);
//            drawerLayout.closeDrawers();
//            changeContainerColor(view.getId());
//
//        }
    }

    private void changeContainerColor(int id) {

//        if (id == R.id.dashboard_container) {
//
//            dashboardContainer.setSelected(true);
//
//        }
    }

}
