package com.thebaileybrew.doublebmediaplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {
    //Follow this tutorial
    //https://www.journaldev.com/13792/android-gridlayoutmanager-example

    ArrayList genreValues;
    Context genreContext;
    ItemListener genreListener;

    public GenreAdapter (Context context, ArrayList values, ItemListener itemListener) {

        this.genreValues = values;
        this.genreContext = context;
        this.genreListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView genreName;
        public ImageView genreBackground;
        public ImageView genreIcon;
        genreItem genreItem;

        public ViewHolder(View genreView) {
            super(genreView);
            genreView.setOnClickListener(this);

            genreName = genreView.findViewById(R.id.genre_name);
            genreBackground = genreView.findViewById(R.id.genre_background);
            genreIcon = genreView.findViewById(R.id.genre_icon);
        }

        @Override
        public void onClick(View view) {
            if (genreListener != null) {
                genreListener.onItemClick(genreItem);
            }
        }
    }

    GenreAdapter(ArrayList<genreItem> genreValues) {this.genreValues = genreValues;}

    @Override
    public GenreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(genreContext).inflate(R.layout.genre_display_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //TODO Figure out Holder Details
    }

    @Override
    public int getItemCount() {
        return genreValues.size();
    }

    public interface ItemListener {
        void onItemClick(genreItem item);
    }
}
