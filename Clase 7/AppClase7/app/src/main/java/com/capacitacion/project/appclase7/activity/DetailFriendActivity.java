package com.capacitacion.project.appclase7.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.capacitacion.project.appclase7.R;
import com.capacitacion.project.appclase7.adapter.RecyclerViewAdapter;
import com.capacitacion.project.appclase7.domain.Friend;
import com.capacitacion.project.appclase7.rest.ApiClient;
import com.capacitacion.project.appclase7.rest.response.DetailFriendResponse;
import com.capacitacion.project.appclase7.rest.response.ListFriendResponse;
import com.capacitacion.project.appclase7.utils.JsonUtils;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFriendActivity extends AppCompatActivity {

    private ImageView iviFriend;
    private TextView tviName;
    private TextView tviLastName;
    private TextView tviDNI;
    private View rlaLoading;

    private Friend friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_friend);

        initUI();
        loadData();
    }

    private void initUI(){

        iviFriend = (ImageView) findViewById(R.id.iviFriend);
        tviName = (TextView) findViewById(R.id.tviName);
        tviLastName = (TextView) findViewById(R.id.tviLastName);
        tviDNI = (TextView) findViewById(R.id.tviDNI);
        rlaLoading = findViewById(R.id.rlaLoading);

    }

    private void loadData(){

        if(getIntent().getExtras() != null){
            friend = (Friend) getIntent().getExtras().getSerializable("FRIEND");

            getListFriendForIdUser(friend.getId());
        }

    }

    private void loadDataFriend(Friend friend){
        if(friend.getImage() != null) Picasso.with(this).load(friend.getImage()).into(iviFriend);
        if(friend.getName() != null) tviName.setText(friend.getName());
        if(friend.getLastname() != null) tviLastName.setText(friend.getLastname());
        if(friend.getDni() != null) tviDNI.setText(friend.getDni());



    }

    private void getListFriendForIdUser(String idFriend){
        rlaLoading.setVisibility(View.VISIBLE);


        Call<DetailFriendResponse> detailFriendResponseCall = ApiClient.getApiInterface().getDetailFriendForId(idFriend);

        detailFriendResponseCall.enqueue(new Callback<DetailFriendResponse>() {
            @Override
            public void onResponse(Call<DetailFriendResponse> call, Response<DetailFriendResponse> response) {
                Log.i("LIST FRIEND RESPONSE", " - " + JsonUtils.generateJSONObject(response.body()).toString());

                rlaLoading.setVisibility(View.GONE);

                DetailFriendResponse detailFriendResponse = response.body();

                Friend friend = new Friend();
                friend.setDni(detailFriendResponse.getDni());
                friend.setName(detailFriendResponse.getName());
                friend.setImage(detailFriendResponse.getImage());
                friend.setId(detailFriendResponse.getId());
                friend.setLastname(detailFriendResponse.getLastname());
                friend.setFriendList(detailFriendResponse.getListfriends());
                loadDataFriend(friend);

            }

            @Override
            public void onFailure(Call<DetailFriendResponse> call, Throwable throwable) {
                rlaLoading.setVisibility(View.GONE);
                Log.i("LIST FRIEND", " - FAIL");

            }
        });

    }

}
