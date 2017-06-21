package com.project.jebus.appsolar.presenter;

import android.content.Context;

import com.project.jebus.appsolar.interactor.ListVideoCallback;
import com.project.jebus.appsolar.interactor.ListVideoInteractor;
import com.project.jebus.appsolar.model.ErrorEntity;
import com.project.jebus.appsolar.ui.view.ListVideoView;

/**
 * Created by jebus on 02/02/2016.
 */
public class ListVideoPresenter implements ListVideoCallback {

    private static final int INDEX_SERVICE_LIST_VIDEO = 10001;

    private ListVideoInteractor listVideoInteractor;
    private ListVideoView listVideoView;
    private Context context;

    public ListVideoPresenter(ListVideoView listVideoView){
        this.listVideoView = listVideoView;
        listVideoInteractor = new ListVideoInteractor();
        context = listVideoView.getViewContext();
    }

    public void serviceGetListVideo(String key, String part, String q, int maxResults, String regionCode){
        listVideoInteractor.listBeachService(context, key, part, q, maxResults, regionCode, this);
    }

    @Override
    public void onResponse(Object object) {
        listVideoView.serviceResult(object, INDEX_SERVICE_LIST_VIDEO);
    }

    @Override
    public void onNetworkConnectionError() {
        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.setMessage("No exite conexión a Internet");
        listVideoView.serviceError(errorEntity, INDEX_SERVICE_LIST_VIDEO);
    }

    @Override
    public void onServerError(String message) {
        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.setMessage(message);
        listVideoView.serviceError(errorEntity, INDEX_SERVICE_LIST_VIDEO);
    }
}
