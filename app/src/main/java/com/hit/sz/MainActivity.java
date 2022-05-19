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

    /*


    难度选择实现

    选择完跳转到gameView，接上就好！


     */
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



    /*


    音频播放实现
    按钮点1下开始循环播放，再点一下
    ps：其实不需要survice，越简单越好

     */

    private Button musicbutton;
    private int state;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private boolean flag = true;
    private MediaPlayer Player = new MediaPlayer();


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
                else {
                    state=0;
                    Player.stop();
                }
            }
        });


    }

}