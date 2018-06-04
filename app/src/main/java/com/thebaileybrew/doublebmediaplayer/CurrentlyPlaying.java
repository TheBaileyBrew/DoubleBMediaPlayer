package com.thebaileybrew.doublebmediaplayer;

import android.content.Intent;
import android.os.Bundle;
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
    BubbleSeekBar musicSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SongItems = new ArrayList<>();
        SongItems.add(new songItem(1,"Luca Stricagnoli","Thunderstruck",R.drawable.luca_image_300, "Instrumental"));
        SongItems.add(new songItem(2,"Pop Evil", "Monster You Made", R.drawable.pop_evil_700, "Rock"));
        SongItems.add(new songItem(3,"Disturbed", "Sound of Silence", R.drawable.disturbed_300, "Rock"));
        SongItems.add(new songItem(4,"Metallica","Fade to Black", R.drawable.metallica_400, "Rock"));
        SongItems.add(new songItem(5,"Pop Evil", "Waking Lions", R.drawable.pop_evil_700, "Rock"));
        SongItems.add(new songItem(6,"Pop Evil", "The Big House",R.drawable.pop_evil_700, "Rock"));
        SongItems.add(new songItem(7,"Metallica", "Enter The Sandman", R.drawable.metallica_400, "Rock"));
        SongItems.add(new songItem(8,"Two Cellos", "Smells Like Teen Spirit", R.drawable.twocellos_900, "Instrumental"));
        SongItems.add(new songItem(9,"Lindsey Stirling", "Radioactive",R.drawable.lindsey_stirling_1000, "Instrumental"));
        SongItems.add(new songItem(10, "Two Cellos", "Smooth Criminal", R.drawable.twocellos_900, "Instrumental"));
        SongItems.add(new songItem(11, "Andy McKee", "Art of Motion", R.drawable.andymckee_800,"Instrumental"));
        SongItems.add(new songItem(12, "The Chainsmokers", "Everybody Hates Me", R.drawable.chainsmokers_500, "Electronic"));
        SongItems.add(new songItem(13, "The Chainsmokers", "Sick Boy", R.drawable.chainsmokers_500, "Electronic"));
        SongItems.add(new songItem(14, "Ed Sheeran", "Shape of You", R.drawable.sheeran_700, "Pop"));
        SongItems.add(new songItem(15, "Fall Out Boy", "Hum Hallelujah", R.drawable.falloutboy_500, "Alt Rock"));
        SongItems.add(new songItem(16, "Green Day", "American Idiot", R.drawable.greenday_700, "Alt Rock"));
        SongItems.add(new songItem(17, "Fall Out Boy", "The Mighty Fall", R.drawable.falloutboy_500, "Alt Rock"));
        SongItems.add(new songItem(18, "Imagine Dragons", "Radioactive", R.drawable.imaginedragons_1000, "Pop"));
        SongItems.add(new songItem(19, "Imagine Dragons", "Thunder", R.drawable.imaginedragons_1000, "Pop"));
        SongItems.add(new songItem(20, "Marshmello", "Alone", R.drawable.marshmello_900, "Electronic"));

        setContentView(R.layout.activity_currently_playing);
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
        currentImage = getIntent().getIntExtra("SelectedImage", 0);
        currentArtist = getIntent().getStringExtra("SelectedArtist");
        currentSong = getIntent().getStringExtra("SelectedSong");
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

    @Override
    public void onClick(View v) {
        int clickedId = v.getId();
        switch (clickedId) {
            case R.id.song_forward:
                if (temporaryCount == 19) {
                    temporaryCount = 0;
                }
                temporaryCount = temporaryCount + 1;
                nowPlayingArtistImage.setImageResource(SongItems.get(temporaryCount).getImage());
                nowPlayingArtist.setText(SongItems.get(temporaryCount).getArtistName());
                nowPlayingSong.setText(SongItems.get(temporaryCount).getSongName());
                break;
            case R.id.song_rewind:
                if (temporaryCount == 0) {
                    temporaryCount = 19;
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
                Collections.shuffle(SongItems);
                Toast.makeText(this, "You've shuffled the ArrayList. Random song will be selected", Toast.LENGTH_SHORT).show();
                nowPlayingArtistImage.setImageResource(SongItems.get(temporaryCount).getImage());
                nowPlayingArtist.setText(SongItems.get(temporaryCount).getArtistName());
                nowPlayingSong.setText(SongItems.get(temporaryCount).getSongName());
        }
    }
}
