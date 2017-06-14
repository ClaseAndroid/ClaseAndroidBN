package com.capacitacion.project.appclase6;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.capacitacion.project.appclase6.adapter.ScreenSlidePagerAdapter;
import com.capacitacion.project.appclase6.model.VersionAndroidEntity;
import com.capacitacion.project.appclase6.view.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.pager) ViewPager mPager;

    private List<VersionAndroidEntity> versionAndroidEntityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        initUI();
        loadData();

    }

    private void initUI(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setContentInsetsAbsolute(0, 0);
    }

    private void loadData(){
        loadDataVersionAndroid();
        ScreenSlidePagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), versionAndroidEntityList);
        mPager.setAdapter(mPagerAdapter);
    }

    private void loadDataVersionAndroid(){

        versionAndroidEntityList.add(new VersionAndroidEntity("Android 1.6 Donut", R.drawable.ic_donut));
        versionAndroidEntityList.add(new VersionAndroidEntity("Android 2.0/2.1 Eclair", R.drawable.ic_eclair));
        versionAndroidEntityList.add(new VersionAndroidEntity("Android 2.2.x Froyo", R.drawable.ic_froyo));
        versionAndroidEntityList.add(new VersionAndroidEntity("Android 2.3.x Gingerbread", R.drawable.ic_gingerbread));
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void nextVersionAndroid(int position) {

    }
}
