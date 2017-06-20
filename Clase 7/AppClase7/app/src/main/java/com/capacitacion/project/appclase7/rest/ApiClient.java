package com.capacitacion.project.appclase7.rest;

import com.capacitacion.project.appclase7.domain.User;
import com.capacitacion.project.appclase7.rest.raw.LoginRaw;
import com.capacitacion.project.appclase7.rest.response.DetailFriendResponse;
import com.capacitacion.project.appclase7.rest.response.ListFriendResponse;
import com.capacitacion.project.appclase7.rest.response.ListOperacionesResponse;
import com.capacitacion.project.appclase7.rest.response.LoginResponse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jesus on 15/06/17.
 */

public class ApiClient {

    private static String PATH = "http://dev-foodcourt.osp.pe/api/v1/proof/";
    private static String PATH_PRUEBA = "http://servicios.ine.es/wstempus/js/ES/";
    private static  Retrofit retrofit;

    public static ApiInterface getApiInterface(){

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(PATH)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        return apiInterface;

    }

    public static ApiInterface getApiInterfacePrueba(){

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PATH_PRUEBA)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        return apiInterface;

    }


    public interface ApiInterface {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter

        @POST("login")
        Call<LoginResponse> loginUser(@Body LoginRaw loginRaw);

        @GET("friends/{idUser}")
        Call<ListFriendResponse> getListFriendForId(@Path("idUser") String idUser);

        @GET("friends-detail")
        Call<DetailFriendResponse> getDetailFriendForId(@Query("id") String idFriend);

        @GET("OPERACIONES_DISPONIBLES")
        Call<ListOperacionesResponse> getOperaciones();

    }

}
