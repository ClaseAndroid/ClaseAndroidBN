package com.capacitacion.project.appclase7.rest;

import com.capacitacion.project.appclase7.domain.User;
import com.capacitacion.project.appclase7.rest.raw.LoginRaw;
import com.capacitacion.project.appclase7.rest.response.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jesus on 15/06/17.
 */

public class ApiClient {

    private static String PATH = "http://www.google.com";
    private static  Retrofit retrofit;

    public static ApiInterface getApiInterface(){

        retrofit = new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        return apiInterface;

    }


    public interface ApiInterface {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter

        @POST("users/login")
        Call<LoginResponse> loginUser(@Body LoginRaw loginRaw);

        @GET("friend/{idFriend}")
        Call<User> getFriend(@Path("idFriend") String idFriend);

        @GET("friend")
        Call<List<User>> getDetailFriend(@Query("email") String email);


    }

}
