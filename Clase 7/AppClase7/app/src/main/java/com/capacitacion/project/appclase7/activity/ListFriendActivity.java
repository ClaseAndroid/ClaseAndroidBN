package com.capacitacion.project.appclase7.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.capacitacion.project.appclase7.R;
import com.capacitacion.project.appclase7.domain.Friend;
import com.capacitacion.project.appclase7.rest.ApiClient;
import com.capacitacion.project.appclase7.rest.raw.LoginRaw;
import com.capacitacion.project.appclase7.rest.response.LoginResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFriendActivity extends AppCompatActivity {

    private RecyclerView rviFriend;
    private Button butFriend;
    private View rlaLoading;

    private List<Friend> friendList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);

        initUI();
        loadData();


    }

    private void initUI(){

        rviFriend = (RecyclerView) findViewById(R.id.rviFriend);
        butFriend = (Button) findViewById(R.id.butFriend);
        rlaLoading = findViewById(R.id.rlaLoading);

        rviFriend.setLayoutManager(new LinearLayoutManager(this));

    }

    private void loadData(){

    }

    private void getListFriendForIdUser(String id){
        rlaLoading.setVisibility(View.VISIBLE);


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
