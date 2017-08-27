package xyz.moechat.sws3d;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by timeloveboy on 16/5/1.
 */
public class  MediaServer extends Service {

    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onStart(Intent intent,int startId){
        super.onStart(intent, startId);

        if(mediaPlayer==null){

// R.raw.mmp是资源文件，MP3格式的
            mediaPlayer = MediaPlayer.create(this, R.raw.sws);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    @Override
    public void onDestroy() {
// TODO Auto-generated method stub
        super.onDestroy();
        mediaPlayer.stop();
    }
}