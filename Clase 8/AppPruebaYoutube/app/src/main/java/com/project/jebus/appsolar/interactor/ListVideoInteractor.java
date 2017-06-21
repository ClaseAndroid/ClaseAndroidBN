package com.project.jebus.appsolar.interactor;

import android.content.Context;

import com.project.jebus.appsolar.model.ErrorEntity;
import com.project.jebus.appsolar.model.VideoResponse;
import com.project.jebus.appsolar.request.ApiClient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jebus on 19/01/16.
 */
public class ListVideoInteractor extends BaseJebusInteractor {


    public void listBeachService(Context context,
                                 String key,
                                 String part,
                                 String q,
                                 int maxResults,
                                 String regionCode,
                                 final ListVideoCallback listVideoCallback) {
        if(isInternetAvailable(context)){
            ApiClient.getSolarApiClient().getListVideo(key, part, q, maxResults, regionCode, new Callback<VideoResponse>() {
                @Override
                public void success(VideoResponse baseResponse, Response response) {
                    listVideoCallback.onResponse(baseResponse);
                }

                @Override
                public void failure(RetrofitError error) {
                    ErrorEntity errorEntity = getError(error);

                    if (errorEntity != null) {
                        listVideoCallback.onServerError(errorEntity.getMessage());
                    } else {
                        listVideoCallback.onServerError(error.getMessage());
                    }
                }
            });
        }else{
            listVideoCallback.onNetworkConnectionError();
        }
    }
}
