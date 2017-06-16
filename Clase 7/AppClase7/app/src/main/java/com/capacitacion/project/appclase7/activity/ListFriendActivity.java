package com.capacitacion.project.appclase7.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.capacitacion.project.appclase7.R;
import com.capacitacion.project.appclase7.adapter.RecyclerViewAdapter;
import com.capacitacion.project.appclase7.domain.Friend;
import com.capacitacion.project.appclase7.domain.User;
import com.capacitacion.project.appclase7.rest.ApiClient;
import com.capacitacion.project.appclase7.rest.raw.LoginRaw;
import com.capacitacion.project.appclase7.rest.response.ListFriendResponse;
import com.capacitacion.project.appclase7.rest.response.LoginResponse;
import com.capacitacion.project.appclase7.utils.JsonUtils;
import com.capacitacion.project.appclase7.utils.RecyclerItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFriendActivity extends AppCompatActivity {

    private ImageView iviUser;
    private TextView tviName;
    private TextView tviDNI;
    private RecyclerView rviFriend;
    private Button butFriend;
    private View rlaLoading;

    private List<Friend> friendList = new ArrayList<>();
    private RecyclerViewAdapter recyclerViewAdapter;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);

        initUI();
        loadData();


    }

    private void initUI(){

        iviUser = (ImageView) findViewById(R.id.iviUser);
        tviName = (TextView) findViewById(R.id.tviName);
        tviDNI = (TextView) findViewById(R.id.tviDNI);
        rviFriend = (RecyclerView) findViewById(R.id.rviFriend);
        butFriend = (Button) findViewById(R.id.butFriend);
        rlaLoading = findViewById(R.id.rlaLoading);

        rviFriend.setLayoutManager(new LinearLayoutManager(this));

        butFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListFriendForIdUser(user.getId());
            }
        });

        rviFriend.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("FRIEND", friendList.get(position));
                Intent intent = new Intent(ListFriendActivity.this, DetailFriendActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }));

    }

    private void loadData(){

        if(getIntent().getExtras() != null){
            user = (User) getIntent().getExtras().getSerializable("USER");
            loadDataUser(user);
        }

    }

    private void loadDataUser(User user){
        if(user.getImage() != null) Picasso.with(this).load(user.getImage()).into(iviUser);
        if(user.getName() != null) tviName.setText(user.getName() + " " + user.getLastName());
        if(user.getDni() != null) tviDNI.setText(user.getDni());
    }

    private void getListFriendForIdUser(String idUser){
        rlaLoading.setVisibility(View.VISIBLE);


        Call<ListFriendResponse> listFriendResponseCall = ApiClient.getApiInterface().getListFriendForId(idUser);

        listFriendResponseCall.enqueue(new Callback<ListFriendResponse>() {
            @Override
            public void onResponse(Call<ListFriendResponse> call, Response<ListFriendResponse> response) {
                Log.i("LIST FRIEND RESPONSE", " - " + JsonUtils.generateJSONObject(response.body()));

                rlaLoading.setVisibility(View.GONE);
                friendList = response.body();

                recyclerViewAdapter = new RecyclerViewAdapter(friendList, ListFriendActivity.this);
                rviFriend.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void onFailure(Call<ListFriendResponse> call, Throwable throwable) {
                rlaLoading.setVisibility(View.GONE);
                Log.i("LIST FRIEND", " - FAIL");

            }
        });

    }
}
