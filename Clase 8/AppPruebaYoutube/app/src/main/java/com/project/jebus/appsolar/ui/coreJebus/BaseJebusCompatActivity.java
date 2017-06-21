package com.project.jebus.appsolar.ui.coreJebus;

/**
 * Created by jebus on 31/01/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;

/**
 * Created by jebus on 11/01/16.
 */
public class BaseJebusCompatActivity extends AppCompatActivity {

    private static final String TAG = "BaseCompatActivity";

    protected void nextActivity(Class<?> activity) {
        this.nextActivity(activity, false);
    }

    protected void nextData(Class<?> activity, Bundle bundle) {
        this.nextData(activity, bundle, false);
    }

    protected void nextActivity(Class<?> activity, boolean notDestroy) {
        this.startActivity(new Intent(this, activity));
        if(!notDestroy) {
            this.finish();
        }
    }

    protected void nextData(Class<?> activity, Bundle bundle, boolean notDestroy) {
        Intent intent = new Intent(this, activity);
        intent.putExtras(bundle);
        this.startActivity(intent);
        if(!notDestroy) {
            this.finish();
        }
    }
    protected void showSnackbar(View view, String message) {
        SpannableStringBuilder snackbarText = new SpannableStringBuilder();
        int boldStart = snackbarText.length();
        snackbarText.append(message);
        snackbarText.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Snackbar snackbar= Snackbar.make(view, snackbarText, Snackbar.LENGTH_LONG);
        snackbar.setCallback(new Snackbar.Callback() {

            @Override
            public void onDismissed(Snackbar snackbar, int event) {
            }

            @Override
            public void onShown(Snackbar snackbar) {
            }
        });
        snackbar.show();
    }

}