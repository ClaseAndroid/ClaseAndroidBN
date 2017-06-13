package com.capacitacion.project.appclase6serviceasynctask.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by OSP on 13/06/17.
 */

public class ServicePrueba extends Service {

    private static final String TAG = ServicePrueba.class.getName();

    public ServicePrueba(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "Servicio creado...");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Servicio iniciado...");

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Servicio destruido...");

    }
}
