package com.capacitacion.project.clase8.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.capacitacion.project.clase8.R;
import com.capacitacion.project.clase8.utils.FacebookUtil;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class MainActivity extends AppCompatActivity {

    private LoginButton login_button;
    private CallbackManager callbackManager;
    private Button butShareURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        loadData();
    }

    private void initUI(){

       // FacebookUtil.getKashFacebok(this);

        login_button = (LoginButton) findViewById(R.id.login_button);
        butShareURL = (Button) findViewById(R.id.butShareURL);


        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        callbackManager = CallbackManager.Factory.create();


        login_button.setReadPermissions("email");

        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("LoginResult - ", loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                Log.i("LoginResult - ", "CANCEL");

            }

            @Override
            public void onError(FacebookException error) {
                Log.i("LoginResult - ", error.getMessage());

            }
        });

        butShareURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareLinkContent content = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://developers.facebook.com"))
                        .build();
                ShareDialog shareDialog = new ShareDialog(MainActivity.this);
                shareDialog.show(content);
            }
        });

    }

    private void loadData(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


}
