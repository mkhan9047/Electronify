package com.example.mujahid.electronify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class abouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abouts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About");

    }


    public void Email(View view){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 1; i++){

                  for(int j = 0; j<=360; j++){

                      ImageView imageView = (ImageView)findViewById(R.id.imageView4);
                      imageView.setRotation((float)j);
                      try {
                          Thread.sleep(5);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }

                    if(i==1){
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto: mkhan9047@gmail.com"));
                        startActivity(Intent.createChooser(intent, "Send Email"));
                    }
                }
            }
        };
       Thread a = new Thread(runnable);
        a.start();


    }

    public void facebook(View view){



        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 1; i++){
                    for(int j = 0; j<=360; j++){
                        ImageView imageView = (ImageView)findViewById(R.id.imageView3);
                        imageView.setRotation((float)j);

                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if(i==1){

                        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com/mujahid.khan.948"));
                        startActivity(intent);
                    }
                }
            }
        };
        Thread a = new Thread(runnable);
        a.start();





    }

}
