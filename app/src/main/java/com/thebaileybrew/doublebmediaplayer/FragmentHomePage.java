package com.thebaileybrew.doublebmediaplayer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialleanback.MaterialLeanBack;

import java.util.ArrayList;
import java.util.List;

public class FragmentHomePage extends Fragment {
    public static FragmentHomePage newInstance() {
        FragmentHomePage fragment = new FragmentHomePage();
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final List<songItem> SongItems;
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

        MaterialLeanBack materialLeanBack = view.findViewById(R.id.material_leanback);
        materialLeanBack.setAdapter(new MaterialLeanBack.Adapter<MusicViewHolder>() {
            @Override
            public int getLineCount() {
                return SongItems.size();
            }

            @Override
            public int getCellsCount(int row) {
                return 1;
            }

            @Override
            public MusicViewHolder onCreateViewHolder(ViewGroup viewGroup, int row) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_display_item, viewGroup,false);
                return new MusicViewHolder(view);
            }

            @Override
            public void onBindViewHolder(MusicViewHolder viewHolder, int position) {
                viewHolder.songArtist.setText(SongItems.get(position).getArtistName());
                viewHolder.songName.setText(SongItems.get(position).getSongName());
                viewHolder.songImage.setImageResource(SongItems.get(position).getImage());
            }
        });


        materialLeanBack.setOnItemClickListener(new MaterialLeanBack.OnItemClickListener() {
            @Override
            public void onTitleClicked(int row, String text) {

            }

            @Override
            public void onItemClicked(int row, int column) {

            }
        });

        return view;
    }
}
