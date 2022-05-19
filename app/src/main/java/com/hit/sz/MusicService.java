package com.hit.sz;

import android.app.Service;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.Provider;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    public MusicService(){}


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MusicControl();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
   class MusicControl extends Binder{
        public void play(){
            mediaPlayer.reset();
            mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.bgm);
            mediaPlayer.start();
        }
        public void stop(){
            mediaPlayer.stop();
            mediaPlayer.release();
        }




   }

}
