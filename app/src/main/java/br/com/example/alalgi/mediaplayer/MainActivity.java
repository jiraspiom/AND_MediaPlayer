package br.com.example.alalgi.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button buttonPlay, buttonPause, buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);


        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executaSom();
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausaSom();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSom();

            }
        });

    }

    public void executaSom(){
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void pausaSom(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void stopSom(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();

            //apos para a musica o media player vai estar null, então carrego a musica novament.
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        }
    }


}
