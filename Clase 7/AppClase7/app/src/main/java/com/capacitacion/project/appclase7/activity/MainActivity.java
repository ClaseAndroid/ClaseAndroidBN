package com.capacitacion.project.appclase7.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.capacitacion.project.appclase7.R;
import com.capacitacion.project.appclase7.domain.User;
import com.capacitacion.project.appclase7.rest.ApiClient;
import com.capacitacion.project.appclase7.rest.raw.LoginRaw;
import com.capacitacion.project.appclase7.rest.response.LoginResponse;
import com.capacitacion.project.appclase7.utils.JsonUtils;

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

                /*
                String email = eteEmail.getText().toString();
                String password = etePassword.getText().toString();

                loginUser(email, password);
            */
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
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
                Log.i("LOGIN RESPONSE", " - " + JsonUtils.generateJSONObject(response.body()).toString());

                LoginResponse loginResponse = response.body();
                User user = new User();
                user.setEmail(loginResponse.getEmail());
                user.setDni(loginResponse.getDni());
                user.setId(loginResponse.getId());
                user.setName(loginResponse.getName());
                user.setLastName(loginResponse.getLastname());
                user.setImage(loginResponse.getImage());

                Bundle bundle = new Bundle();
                bundle.putSerializable("USER", user);
                Intent intent = new Intent(MainActivity.this, ListFriendActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                rlaLoading.setVisibility(View.GONE);
                Log.i("LOGIN", " - FAIL");

            }
        });

    }
}
