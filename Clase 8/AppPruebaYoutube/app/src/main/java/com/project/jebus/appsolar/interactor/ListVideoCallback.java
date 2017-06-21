package com.project.jebus.appsolar.interactor;

/**
 * Created by jebus on 11/12/15.
 */
public interface ListVideoCallback {

    void onResponse(Object object);

    void onNetworkConnectionError();

    void onServerError(String message);
}
