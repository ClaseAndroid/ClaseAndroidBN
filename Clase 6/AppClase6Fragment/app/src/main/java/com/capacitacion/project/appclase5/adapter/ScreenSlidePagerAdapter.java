package com.capacitacion.project.appclase5.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.capacitacion.project.appclase5.model.VersionAndroidEntity;
import com.capacitacion.project.appclase5.fragment.VersionAndroidFragment;

import java.util.List;

/**
 * Created by jebus on 02/04/2016.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<VersionAndroidEntity> versionAndroidEntityList;

    public ScreenSlidePagerAdapter(FragmentManager fm, List<VersionAndroidEntity> versionAndroidEntityList) {
        super(fm);
        this.versionAndroidEntityList = versionAndroidEntityList;
    }

    @Override
    public Fragment getItem(int position) {
        return VersionAndroidFragment.newInstanceOne(
                versionAndroidEntityList.get(position).getNameVersion(),
                versionAndroidEntityList.get(position).getImageVersion());
    }

    @Override
    public int getCount() {
        return versionAndroidEntityList.size();
    }
}
