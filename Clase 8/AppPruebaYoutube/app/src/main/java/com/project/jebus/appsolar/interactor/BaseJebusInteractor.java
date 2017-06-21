package com.project.jebus.appsolar.interactor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.project.jebus.appsolar.model.ErrorEntity;
import com.project.jebus.appsolar.model.response.BaseResponse;
import com.project.jebus.appsolar.ui.coreJebus.JSONJebus;

import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 * Created by jebus on 19/01/16.
 */
public class BaseJebusInteractor {

    public static String getTokenString(Response response) {
        for (Header header : response.getHeaders()) {
            if (null!= header.getName() && header.getName().equals("_token")) {
                return header.getValue();
            }
        }
        return null;
    }

    public ErrorEntity getError(RetrofitError data) {

        ErrorEntity errorEntity = null;

        if(data == null){
            return errorEntity;
        }
        try {
            String json = new String(((TypedByteArray)data.getResponse().getBody()).getBytes());
            errorEntity.setMessage(buildJSONArrayBody(json));
        }catch (NullPointerException e) {

        }

        return errorEntity;
    }

    private String buildJSONArrayBody(String json) {
        String message = "";
        if(TextUtils.isEmpty(json)) return "Server Error";
        try{
            BaseResponse baseResponse = (BaseResponse) JSONJebus.jsonStringToObject(json, BaseResponse.class);
            if(baseResponse.getData_error().size() > 0){
                if(baseResponse.getData_error().get(0).getMsg() != null && baseResponse.getData_error().get(0).getMsg().size() > 0){
                    message = baseResponse.getData_error().get(0).getMsg().get(0);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return message;
    }

    public boolean isInternetAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager . getActiveNetworkInfo ();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected ();

    }
}
