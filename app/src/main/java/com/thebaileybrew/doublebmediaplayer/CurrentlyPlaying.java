package com.thebaileybrew.doublebmediaplayer;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
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

    private MediaPlayer mediaPlayer;


    List<songItem> SongItems;
    int temporaryCount;
    String currentArtist;
    String currentSong;
    String currentGenre;
    int currentImage;
    int currentPosition;
    int currentPlayingSong = 0;
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
    Boolean isPaused = false;
    Boolean isShuffled = false;
    Boolean genrePlaylist = false;
    BubbleSeekBar musicSeekbar;
    Handler updateHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        songArrayList songs = new songArrayList();
        ArrayList<songItem> tempList = new ArrayList();
        SongItems = songs.getSongList();
        Toast.makeText(this, "SongSize is currently: " + String.valueOf(SongItems.size()), Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_currently_playing);

        //Define runnable for seekbar progression
        initializeViews();
        currentGenre = getIntent().getStringExtra("SelectedGenre");
        genrePlaylist = getIntent().getBooleanExtra("Playlist", false);
        currentImage = getIntent().getIntExtra("SelectedImage", 0);
        currentArtist = getIntent().getStringExtra("SelectedArtist");
        currentSong = getIntent().getStringExtra("SelectedSong");
        currentPosition = getIntent().getIntExtra("Position", 0);
        currentPlayingSong = SongItems.get(temporaryCount).getSongPlayable();
        if (genrePlaylist) {
            for (songItem song : SongItems) {
                if (song.getGenre().equals(currentGenre)) {
                    tempList.add(song);
                }
            }
            SongItems.clear();
            SongItems = tempList;
            temporaryCount = currentPosition + 2;
            Toast.makeText(this, "Current position is: " + String.valueOf(temporaryCount), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Current SongSize is: " + String.valueOf(SongItems.size()), Toast.LENGTH_SHORT).show();
        } else {
            temporaryCount = currentPosition - 1;
            Toast.makeText(this, "Current position is: " + String.valueOf(temporaryCount), Toast.LENGTH_SHORT).show();
        }
        //Set initial Current Playing view
        nowPlayingArtist.setText(currentArtist);
        nowPlayingSong.setText(currentSong);
        nowPlayingArtistImage.setImageResource(currentImage);
        //Set onClickListeners for buttons
        playButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        reverseButton.setOnClickListener(this);
        shuffleButton.setOnClickListener(this);
        loopButton.setOnClickListener(this);
        listButton.setOnClickListener(this);
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
        currentPlayingSong = SongItems.get(temporaryCount).getSongPlayable();
        switch (clickedId) {
            case R.id.song_forward:
                if (temporaryCount == SongItems.size() - 1) {
                    temporaryCount = -1;
                }
                temporaryCount = temporaryCount + 1;
                if(isPlaying) {
                    //If song is currently playing and skip forward selected, then next song in list will automatically play
                    mediaPlayer.stop();
                    releaseMediaPlayer();
                    getCurrentPlaying();
                    mediaPlayer.start();
                }
                if(isPaused) {
                    //If song is currently paused and skip forward selected, then next song in list will be queued up
                    mediaPlayer.stop();
                    releaseMediaPlayer();
                    getCurrentPlaying();
                    playButton.setText("PLAY");
                }
                nowPlayingArtistImage.setImageResource(SongItems.get(temporaryCount).getImage());
                nowPlayingArtist.setText(SongItems.get(temporaryCount).getArtistName());
                nowPlayingSong.setText(SongItems.get(temporaryCount).getSongName());
                break;
            case R.id.song_rewind:
                if (temporaryCount == 0) {
                    temporaryCount = SongItems.size();
                }
                temporaryCount = temporaryCount - 1;
                currentPlayingSong = SongItems.get(temporaryCount).getSongPlayable();
                nowPlayingArtistImage.setImageResource(SongItems.get(temporaryCount).getImage());
                nowPlayingArtist.setText(SongItems.get(temporaryCount).getArtistName());
                nowPlayingSong.setText(SongItems.get(temporaryCount).getSongName());
                if(isPlaying) {
                    //If song is currently playing and go backward selected, then previous song in list will automatically play
                    mediaPlayer.stop();
                    releaseMediaPlayer();
                    getCurrentPlaying();
                    mediaPlayer.start();
                }
                if(isPaused) {
                    //If song is currently paused and go backward selected, the previous song in list will be queued up
                    mediaPlayer.stop();
                    releaseMediaPlayer();
                    getCurrentPlaying();
                    playButton.setText("PLAY");
                }
                break;
            case R.id.song_play_pause:
                if (isPlaying) {
                    // Pause Button pressed - song should pause
                    // isPlaying = false; isPaused = true;
                    // Sets Button text to 'PLAY'
                    isPlaying = false;
                    isPaused = true;
                    playButton.setText("PLAY");
                    mediaPlayer.pause();
                } else {
                    // Play Button pressed - song should either resume or new song should start
                    // isPlaying = true; isPaused = false
                    // Sets Button text to 'PAUSE'
                    isPlaying = true;
                    isPaused = false;
                    getCurrentPlaying();
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompleteListener);
                    playButton.setText("PAUSE");

                    //TODO: Set the musicSeekbar progressbar animation
                }
                break;
            case R.id.song_shuffle:
                if (isShuffled) {
                    shuffleButton.setTextColor(getResources().getColor(R.color.colorAccent));
                    isShuffled = false;
                } else {
                    shuffleButton.setTextColor(getResources().getColor(R.color.colorAccentOn));
                    isShuffled = true;
                    Collections.shuffle(SongItems);
                    if(isPlaying) {
                        mediaPlayer.stop();
                        releaseMediaPlayer();
                        getCurrentPlaying();
                        mediaPlayer.start();
                    }
                }
                nowPlayingArtistImage.setImageResource(SongItems.get(temporaryCount).getImage());
                nowPlayingArtist.setText(SongItems.get(temporaryCount).getArtistName());
                nowPlayingSong.setText(SongItems.get(temporaryCount).getSongName());
                currentPlayingSong = SongItems.get(temporaryCount).getSongPlayable();
                break;
            case R.id.song_loop:
                break;
            case R.id.song_playlists:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        //When app is closed or activity stopped, release media player
        releaseMediaPlayer();
    }


    // OnCompletionListener Method
    private MediaPlayer.OnCompletionListener mCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
            isPlaying = false;
        }
    };

    // Release the data in the MediaPlayer
    private void releaseMediaPlayer() {
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    //Get the currently playing song
    private void getCurrentPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        } else {
            currentPlayingSong = SongItems.get(temporaryCount).getSongPlayable();
            mediaPlayer = MediaPlayer.create(CurrentlyPlaying.this, currentPlayingSong);

        }
    }
}
