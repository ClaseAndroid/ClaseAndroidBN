package com.project.jebus.appsolar.request;

import retrofit.RetrofitError;

/**
 * Created by emedinaa on 11/08/15.
 */
public interface IRequestListener {

    void onServiceSuccess(Object object, int type);
    void onServiceError(RetrofitError volleyError, int type);
}
