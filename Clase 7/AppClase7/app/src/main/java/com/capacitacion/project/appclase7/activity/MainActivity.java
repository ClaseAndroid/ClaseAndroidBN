package com.capacitacion.project.appclase7.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.capacitacion.project.appclase7.R;
import com.capacitacion.project.appclase7.domain.User;
import com.capacitacion.project.appclase7.rest.ApiClient;
import com.capacitacion.project.appclase7.rest.raw.LoginRaw;
import com.capacitacion.project.appclase7.rest.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText eteEmail;
    private EditText etePassword;
    private Button butEnter;
    private View rlaLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        loadData();

    }

    private void initUI(){

        eteEmail = (EditText) findViewById(R.id.eteEmail);
        etePassword = (EditText) findViewById(R.id.etePassword);
        butEnter = (Button) findViewById(R.id.butEnter);
        rlaLoading =  findViewById(R.id.rlaLoading);

        butEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = eteEmail.getText().toString();
                String password = etePassword.getText().toString();

                loginUser(email, password);
            }
        });

    }

    private void loadData(){


    }

    private void loginUser(String email, String password){
        rlaLoading.setVisibility(View.VISIBLE);
        LoginRaw loginRaw = new LoginRaw();
        loginRaw.setEmail(email);
        loginRaw.setPassword(password);


        Call<LoginResponse> loginResponseCall = ApiClient.getApiInterface().loginUser(loginRaw);

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                rlaLoading.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                rlaLoading.setVisibility(View.GONE);

            }
        });

    }
}
