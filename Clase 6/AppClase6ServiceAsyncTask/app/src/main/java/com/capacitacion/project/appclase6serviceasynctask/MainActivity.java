package com.capacitacion.project.appclase6serviceasynctask;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.capacitacion.project.appclase6serviceasynctask.service.ServicePrueba;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button butImage;
    private Button butProgress;
    private ImageView mImageView;
    private ProgressDialog mProgressDialog;
    private String url = "http://esphoto500x500.mnstatic.com/banco-de-arena-en-zanzibar_5805011.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butImage = (Button) findViewById(R.id.butImage);
        mImageView = (ImageView) findViewById(R.id.imageView);
        butProgress = (Button) findViewById(R.id.butProgress);

        butImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });
        butProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launchProgressDialog();
                stopService(new Intent(MainActivity.this, ServicePrueba.class));
            }
        });

/*
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                Toast.makeText(MainActivity.this, "Cagando...", Toast.LENGTH_SHORT).show();
              //  handler.postDelayed(this, 5000);
            }
        };

        handler.postDelayed(r, 5000);
*/



        startService(new Intent(MainActivity.this, ServicePrueba.class));
        //stopService(new Intent(MainActivity.this, ServicePrueba.class));

 //   new UploadImage(url).execute();

    }

    /**
     * Cargamos la imagen desde internet en el hilo de interfaz de usuario de nuestra aplicación.
     */
    public void uploadImage() {
        new Thread(new Runnable() {
            // Definiremos el código para ejecutar en este hilo.
            private Bitmap loadImageFromNetwork(String url){
                try {
                    Bitmap mBitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
                    return mBitmap;
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }


            public void run() {
                // Ejecutamos el código definido.

                final Bitmap mBitmap = loadImageFromNetwork(url);

                mImageView.post(new Runnable() {
                    public void run() {
                        mImageView.setImageBitmap(mBitmap);
                    }
                });
            }
        }).start();
    }


    public void launchProgressDialog() {
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setTitle("Simulando descarga ...");
        mProgressDialog.setMessage("Descarga en progreso ...");
        mProgressDialog.setProgressStyle(mProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setProgress(0);
        mProgressDialog.setMax(100);
        mProgressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j=1; j<=20; j++){
                    try{
                        Thread.sleep(1000);
                        mProgressDialog.incrementProgressBy(100/20);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                mProgressDialog.dismiss();
            }
        }).start();

    }


    private class UploadImage extends AsyncTask<Void, Integer, Bitmap> {

        String url;

        public UploadImage(String url){
            this.url = url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Simulando descarga ...");
            mProgressDialog.setMessage("Descarga en progreso ...");
            mProgressDialog.setProgressStyle(mProgressDialog.STYLE_SPINNER);
            mProgressDialog.show();

        }

        @Override
        protected Bitmap doInBackground(Void... strings) {
            try {
                Bitmap mBitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());

                return mBitmap;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mProgressDialog.dismiss();
            mImageView.setImageBitmap(bitmap);
        }
    }
}
