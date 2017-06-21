package com.project.jebus.appsolar.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.project.jebus.appsolar.R;
import com.project.jebus.appsolar.model.UserEntity;
import com.project.jebus.appsolar.storage.AppSolarPreferences;
import com.project.jebus.appsolar.ui.coreJebus.BaseJebusCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseJebusCompatActivity {

    @Bind(R.id.butFacebook) LoginButton loginButton;
    @Bind(R.id.butTwitter) Button butTwitter;

    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();
        loadData();

    }

    private void initUI(){


        callbackManager = CallbackManager.Factory.create();

        loginButton.setReadPermissions("user_friends");
        // If using in a fragment
        //loginButton.setFragment(this);

    }

    private void loadData(){

        if(AccessToken.getCurrentAccessToken()!=null) {
            nextActivity(ListVideoActivity.class, false);
        }
        else {

        }


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                UserEntity userEntity = new UserEntity();
                userEntity.setIdFacebook(loginResult.getAccessToken().getUserId());
                AppSolarPreferences.saveUser(MainActivity.this, userEntity);
                nextActivity(ListVideoActivity.class, false);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
/*
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.project.jebus.appsolar",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
