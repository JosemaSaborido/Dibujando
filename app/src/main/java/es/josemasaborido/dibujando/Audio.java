package es.josemasaborido.dibujando;

import android.content.Context;
import android.media.MediaPlayer;

public class Audio {
    private MediaPlayer mediaPlayer;

    public void init(Context context){
        mediaPlayer = MediaPlayer.create(context, R.raw.intro);
        mediaPlayer.seekTo(0);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    public void pause(){
        mediaPlayer.pause();
    }
}
