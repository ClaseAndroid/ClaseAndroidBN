package com.project.jebus.appsolar.request;

import com.project.jebus.appsolar.model.HeadersEntity;
import com.project.jebus.appsolar.model.VideoResponse;
import com.squareup.okhttp.OkHttpClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;


/**
 * Created by jebus on 3/09/15.
 */
public class ApiClient {

    private static String PATH = "https://www.googleapis.com/youtube/v3";
    private static final String TAG = "ApiClient";
    private static MovistarApiClient movistarApiClient;
    private static MovistarApiClient movistarApiClientToken;

    public static MovistarApiClient getSolarApiClient()
    {
        if (movistarApiClient == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(PATH)
                    .setClient(new OkClient(getClient()))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
            movistarApiClient = restAdapter.create(MovistarApiClient.class);
        }
        return movistarApiClient;
    }

    public static MovistarApiClient getSolarApiClient(final List<HeadersEntity> headersEntityList) {
        if (movistarApiClientToken == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(PATH)
                    .setClient(new OkClient(getClient()))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setRequestInterceptor(new RequestInterceptor() {
                        @Override
                        public void intercept(RequestInterceptor.RequestFacade request) {
                            if (headersEntityList != null) {
                                for (HeadersEntity headersEntity : headersEntityList)
                                    request.addHeader(headersEntity.getName(), headersEntity.getValue());
                            }
                        }
                    }).build();

            movistarApiClientToken = restAdapter.create(MovistarApiClient.class);
        }
        return movistarApiClientToken;
    }

    public static OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(2, TimeUnit.MINUTES);
        client.setReadTimeout(2, TimeUnit.MINUTES);
        return client;
    }

    public interface MovistarApiClient {

        @Headers({"Content-Type: application/json"})
        @GET("/search")
        void getListVideo(@Query("key") String key,
                          @Query("part") String part,
                          @Query("q") String q,
                          @Query("maxResults") int maxResults,
                          @Query("regionCode") String regionCode,
                          Callback<VideoResponse> callback);

    }

}