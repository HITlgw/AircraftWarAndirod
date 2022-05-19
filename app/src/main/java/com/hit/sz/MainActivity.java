package com.hit.sz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.util.concurrent.locks.Lock;

public class MainActivity extends AppCompatActivity {
//    private Button selectbutton;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        selectbutton = (Button)findViewById(R.id.select);
//        selectbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("1230","21231");
//                showListDialog();
//            }
//        });
//    }
//    private void showListDialog(){
//        final String[] items = {"简单","中等","困难"};
//        AlertDialog.Builder listDialog = new AlertDialog.Builder(MainActivity.this);
//        listDialog.setTitle("选择难度");
//        listDialog.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this,"选择了"+items[which],Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        listDialog.show();
//    }

//    private MusicService.MusicControl control;
    private Button musicbutton;
    private int state;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private boolean flag = true;
    private MediaPlayer Player = new MediaPlayer();

//    private ServiceConnection connection = new ServiceConnection(){
//    @Override
//    public void onServiceConnected(ComponentName name, IBinder service) {
//        control = (MusicService.MusicControl) service;
//    }
//
//    @Override
//    public void onServiceDisconnected(ComponentName name) {
//
//    }
//};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        state=0;

        musicbutton = (Button) findViewById(R.id.select);
        musicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state==0){
                    state=1;
//                    Object Lock = new Object();
                    Thread bgmThread = new Thread(()->
                    {
                            Player.reset();
                            Player = MediaPlayer.create(getApplicationContext(),R.raw.bgm);
                            Player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                Player.start();
                                Player.setLooping(true);
                            }

                            });
                            Player.start();

                    }
                    );
                    bgmThread.start();

                }
                else {
                    state=0;
                    Player.stop();
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                    mediaPlayer = new MediaPlayer();
                }


            }
        });

//        Intent intent = new Intent(getApplicationContext(),MusicService.class);
//        bindService(intent,connection,BIND_AUTO_CREATE);

    }

}