package com.thebaileybrew.doublebmediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xw.repo.BubbleSeekBar;

import java.util.List;

public class CurrentlyPlaying extends AppCompatActivity {

    List<songItem> SongItems;
    String currentArtist;
    String currentSong;
    int currentImage;
    TextView nowPlayingArtist;
    TextView nowPlayingSong;
    ImageView nowPlayingArtistImage;
    Button playButton;
    Button forwardButton;
    Button reverseButton;
    Boolean isPlaying;
    BubbleSeekBar musicSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_playing);
        nowPlayingArtistImage = findViewById(R.id.now_playing_artist_image);
        nowPlayingArtist = findViewById(R.id.now_playing_artist_name);
        nowPlayingSong = findViewById(R.id.now_playing_song_name);
        musicSeekbar = findViewById(R.id.song_progress);
        playButton = findViewById(R.id.song_play_pause);
        isPlaying = false;
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    playButton.setText("PLAY");
                    isPlaying = false;
                } else {
                    playButton.setText("PAUSE");
                    isPlaying = true;
                    //Set the musicSeekbar animation

                }

            }
        });
        forwardButton = findViewById(R.id.song_forward);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nowPlayingArtistImage.setImageResource(SongItems.get(1).getImage());
                nowPlayingArtist.setText(SongItems.get(1).getArtistName());
                nowPlayingSong.setText(SongItems.get(1).getSongName());
            }
        });
        reverseButton = findViewById(R.id.song_rewind);
        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nowPlayingArtistImage.setImageResource(SongItems.get(19).getImage());
                nowPlayingArtist.setText(SongItems.get(19).getArtistName());
                nowPlayingSong.setText(SongItems.get(19).getSongName());
            }
        });

        currentImage = getIntent().getIntExtra("SelectedImage", 0);
        currentArtist = getIntent().getStringExtra("SelectedArtist");
        currentSong = getIntent().getStringExtra("SelectedSong");
        nowPlayingArtist.setText(currentArtist);
        nowPlayingSong.setText(currentSong);
        nowPlayingArtistImage.setImageResource(currentImage);





    }

}
