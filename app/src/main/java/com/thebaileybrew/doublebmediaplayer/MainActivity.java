package com.thebaileybrew.doublebmediaplayer;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class MainActivity extends AppCompatActivity {

    BottomNavigation musicNavigator;
    PagerAdapter musicPagerAdapter;
    ViewPager pager;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);
        setTitle(getResources().getString(R.string.app_name));
        mainToolbar.setLogoDescription(getResources().getString(R.string.logo_desc));

        //https://github.com/florent37/DiagonalLayout

        //https://github.com/florent37/MaterialLeanBack

        //https://github.com/sephiroth74/Material-BottomNavigation

        musicNavigator = findViewById(R.id.bottomNavigation);
        musicNavigator.setSelectedIndex(2, true);
        pager = findViewById(R.id.viewPager);
        musicPagerAdapter = new pagerAdapter(getSupportFragmentManager());
        pager.setAdapter(musicPagerAdapter);
        pager.setCurrentItem(2, true);

        musicNavigator.setOnMenuItemClickListener(new BottomNavigation.OnMenuItemSelectionListener() {
            @Override
            public void onMenuItemSelect(int i, int i1, boolean b) {
                pager.setCurrentItem(i1, true);
            }

            @Override
            public void onMenuItemReselect(int i, int i1, boolean b) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the toolbar menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_new: //Add New Music
                Toast.makeText(this, "You can add local music files...", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_refresh: //Return to Home Page
                Toast.makeText(this, "Refreshing App", Toast.LENGTH_LONG).show();
                pager.setCurrentItem(2, true);
                musicNavigator.setSelectedIndex(2, true);
                break;
            case R.id.action_settings: //Display App Settings
                Toast.makeText(this, "You want to change some settings...", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
