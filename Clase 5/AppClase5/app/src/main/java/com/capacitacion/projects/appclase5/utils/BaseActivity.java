package com.capacitacion.projects.appclase5.utils;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.capacitacion.projects.appclase5.R;

public class BaseActivity extends AppCompatActivity {

    private View vKitkat;

    protected void validateVersion(){
        vKitkat= findViewById(R.id.vKitkat);
        if(vKitkat==null)return;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            vKitkat.setVisibility(View.VISIBLE);
            vKitkat.setPadding(0, 0, 0, ScreenUtils.dpToPx(24));
        } else{
            vKitkat.setVisibility(View.GONE);
        }
    }

    protected void nextActivity(Class<?> activity, boolean notDestroy) {
        this.startActivity(new Intent(this, activity));
        if(!notDestroy) {
            this.finish();
        }
    }
}
