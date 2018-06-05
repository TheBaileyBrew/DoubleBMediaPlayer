package com.thebaileybrew.doublebmediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xw.repo.BubbleSeekBar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CurrentlyPlaying extends AppCompatActivity implements View.OnClickListener{

    List<songItem> SongItems;
    int temporaryCount;
    String currentArtist;
    String currentSong;
    int currentImage;
    int currentPosition;
    TextView nowPlayingArtist;
    TextView nowPlayingSong;
    ImageView nowPlayingArtistImage;
    Button playButton;
    Button forwardButton;
    Button reverseButton;
    Button shuffleButton;
    Button loopButton;
    Button listButton;
    Boolean isPlaying = false;
    Boolean isShuffled = false;
    BubbleSeekBar musicSeekbar;
    Handler updateHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        songArrayList songs = new songArrayList();
        SongItems = songs.getSongList();
        setContentView(R.layout.activity_currently_playing);

        //Define runnable for seekbar progression
        initializeViews();
        currentImage = getIntent().getIntExtra("SelectedImage", 0);
        currentArtist = getIntent().getStringExtra("SelectedArtist");
        currentSong = getIntent().getStringExtra("SelectedSong");
        currentPosition = getIntent().getIntExtra("Position", 0);
        temporaryCount = currentPosition - 1;
        //Set initial Current Playing view
        nowPlayingArtist.setText(currentArtist);
        nowPlayingSong.setText(currentSong);
        nowPlayingArtistImage.setImageResource(currentImage);
        //Set onClickListeners for buttons
        playButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        reverseButton.setOnClickListener(this);
        shuffleButton.setOnClickListener(this);
    }

    private void initializeViews() {
        nowPlayingArtistImage = findViewById(R.id.now_playing_artist_image);
        nowPlayingArtist = findViewById(R.id.now_playing_artist_name);
        nowPlayingSong = findViewById(R.id.now_playing_song_name);
        musicSeekbar = findViewById(R.id.song_progress);
        playButton = findViewById(R.id.song_play_pause);
        forwardButton = findViewById(R.id.song_forward);
        reverseButton = findViewById(R.id.song_rewind);
        shuffleButton = findViewById(R.id.song_shuffle);
        loopButton = findViewById(R.id.song_loop);
        listButton = findViewById(R.id.song_playlists);
    }

    @Override
    public void onClick(View v) {
        int clickedId = v.getId();
        switch (clickedId) {
            case R.id.song_forward:
                if (temporaryCount == 19) {
                    temporaryCount = -1;
                }
                temporaryCount = temporaryCount + 1;
                nowPlayingArtistImage.setImageResource(SongItems.get(temporaryCount).getImage());
                nowPlayingArtist.setText(SongItems.get(temporaryCount).getArtistName());
                nowPlayingSong.setText(SongItems.get(temporaryCount).getSongName());
                break;
            case R.id.song_rewind:
                if (temporaryCount == 0) {
                    temporaryCount = 20;
                }
                temporaryCount = temporaryCount - 1;
                nowPlayingArtistImage.setImageResource(SongItems.get(temporaryCount).getImage());
                nowPlayingArtist.setText(SongItems.get(temporaryCount).getArtistName());
                nowPlayingSong.setText(SongItems.get(temporaryCount).getSongName());
                break;
            case R.id.song_play_pause:
                if (isPlaying) {
                    playButton.setText("PLAY");
                    isPlaying = false;
                } else {
                    playButton.setText("PAUSE");
                    isPlaying = true;
                    //TODO: Set the musicSeekbar progressbar animation
                }
                break;
            case R.id.song_shuffle:
                if (isShuffled) {
                    shuffleButton.setTextColor(getResources().getColor(R.color.colorAccent));
                    isShuffled = false;
                    Toast.makeText(this, "You've turned off the Shuffle", Toast.LENGTH_SHORT).show();
                } else {
                    shuffleButton.setTextColor(getResources().getColor(R.color.colorAccentOn));
                    isShuffled = true;
                    Collections.shuffle(SongItems);
                    Toast.makeText(this, "You've shuffled the ArrayList. Random song will be selected", Toast.LENGTH_SHORT).show();
                }
                nowPlayingArtistImage.setImageResource(SongItems.get(temporaryCount).getImage());
                nowPlayingArtist.setText(SongItems.get(temporaryCount).getArtistName());
                nowPlayingSong.setText(SongItems.get(temporaryCount).getSongName());
        }
    }
}
