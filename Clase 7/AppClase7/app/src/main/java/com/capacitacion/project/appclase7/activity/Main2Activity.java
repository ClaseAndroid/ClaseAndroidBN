package com.capacitacion.project.appclase7.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.capacitacion.project.appclase7.R;
import com.capacitacion.project.appclase7.adapter.RecyclerViewAdapter;
import com.capacitacion.project.appclase7.adapter.RecyclerViewOperacionesAdapter;
import com.capacitacion.project.appclase7.domain.Operaciones;
import com.capacitacion.project.appclase7.rest.ApiClient;
import com.capacitacion.project.appclase7.rest.response.ListFriendResponse;
import com.capacitacion.project.appclase7.rest.response.ListOperacionesResponse;
import com.capacitacion.project.appclase7.utils.JsonUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView rviOperaciones;
    private RecyclerViewOperacionesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rviOperaciones = (RecyclerView) findViewById(R.id.rviOperaciones);
        rviOperaciones.setLayoutManager(new LinearLayoutManager(this));

        getListOperaciones();

    }

    private void getListOperaciones(){

        Call<ListOperacionesResponse> listFriendResponseCall = ApiClient.getApiInterfacePrueba().getOperaciones();

        listFriendResponseCall.enqueue(new Callback<ListOperacionesResponse>() {
            @Override
            public void onResponse(Call<ListOperacionesResponse> call, Response<ListOperacionesResponse> response) {

                List<Operaciones> operacionesList = response.body();

                adapter = new RecyclerViewOperacionesAdapter(operacionesList, Main2Activity.this);
                rviOperaciones.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListOperacionesResponse> call, Throwable throwable) {

            }
        });

    }

}
