package com.example.sandeepkumar.playmusicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

public class MusicPlayService extends Service {

    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        player = new MediaPlayer();
        try {
            player.setDataSource("https://sample-videos.com/audio/mp3/crowd-cheering.mp3");
        } catch ( Exception e) {

        }

        player.setLooping(true); // Set looping
        player.setVolume(50,50);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }
}
