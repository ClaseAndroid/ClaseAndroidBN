package com.capacitacion.project.appclase6serviceasynctask.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Jebus on 13/06/17.
 */

public class ServicePrueba extends Service {

    private static final String TAG = ServicePrueba.class.getName();

    private Handler handler = new Handler();

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

        final Runnable r = new Runnable() {
            public void run() {
                Log.i("HILO", "CARGANDO...");

                Toast.makeText(getApplicationContext(), "Cagando...", Toast.LENGTH_SHORT).show();
                handler.postDelayed(this, 5000);
            }
        };

        handler.post(r);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Servicio destruido...");

    }
}
