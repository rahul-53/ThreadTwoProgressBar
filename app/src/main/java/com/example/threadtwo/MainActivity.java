package com.example.threadtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.transition.CircularPropagation;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {
    private CircularProgressIndicator progressBar;



    private Handler mainThreadHandler = new Handler(Looper.myLooper()){

        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    int progress =(int) msg.obj;
                    progressBar.setProgress(progress);
                    break;
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        WorkerThread workerThread = new WorkerThread("async", mainThreadHandler);
        workerThread.start();
    }


}