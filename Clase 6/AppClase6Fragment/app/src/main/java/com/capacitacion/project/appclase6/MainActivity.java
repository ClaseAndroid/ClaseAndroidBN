package com.capacitacion.project.appclase6;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.capacitacion.project.appclase6.fragment.CupcakeFragment;
import com.capacitacion.project.appclase6.fragment.VersionAndroidFragment;
import com.capacitacion.project.appclase6.view.OnFragmentInteractionListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    @Bind(R.id.left_drawer) ListView mDrawerList;
    @Bind(R.id.drawer_layout) DrawerLayout  mDrawerLayout;
    @Bind(R.id.toolbar) Toolbar toolbar;

    private String[] versionAndroid;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        initUI();
        loadData();

    }

    private void initUI(){

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
               //getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();

        /**
         * Dos maneras de poder pasar informacion a un fragment
         */

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VersionAndroidFragment versionAndroidFragment;
                switch (position) {
                    case 0:
                        versionAndroidFragment = VersionAndroidFragment.newInstanceOne(versionAndroid[position], R.drawable.ic_apple_pie);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, versionAndroidFragment)
                                .commit();
                        break;
                    case 1:
                        versionAndroidFragment = VersionAndroidFragment.newInstanceTwo(versionAndroid[position], R.drawable.ic_banana_bread);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, versionAndroidFragment)
                                .commit();
                        break;
                    case 2:
                        CupcakeFragment cupcakeFragment = CupcakeFragment.newInstanceTwo(versionAndroid[position], R.drawable.ic_cupcake);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, cupcakeFragment)
                                .commit();
                        break;
                    case 3:
                        Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                }

                mDrawerLayout.closeDrawers();
            }
        });
    }

    private void loadData(){
        versionAndroid = getResources().getStringArray(R.array.array_menu);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, versionAndroid));
        // Set the list's click listener

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void nextVersionAndroid(int position) {
        VersionAndroidFragment versionAndroidFragment;
        switch (position){
            case 1:
                versionAndroidFragment = VersionAndroidFragment.newInstanceTwo(versionAndroid[position], R.drawable.ic_apple_pie);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, versionAndroidFragment)
                        .commit();
                break;
            case 2:
                versionAndroidFragment = VersionAndroidFragment.newInstanceTwo(versionAndroid[position], R.drawable.ic_banana_bread);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, versionAndroidFragment)
                        .commit();
                break;
        }
    }
}
