package com.thebaileybrew.doublebmediaplayer;

import android.view.View;

//This is a unique interface designed for the GridView Recycler
// This interface is called when used clicks on one of the items in the grid.

public interface CustomerGenreClickInterface {
    void onItemClick(View v, int position);
}
