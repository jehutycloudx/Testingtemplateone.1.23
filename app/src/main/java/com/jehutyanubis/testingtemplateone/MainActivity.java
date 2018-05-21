package com.jehutyanubis.testingtemplateone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager; /*created in activity main XML all the way at the bottom*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        /* create view pager object above ^^ as that is what we will be referencing*/

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        /* reference the container as this is what we will be swapping the fragments out of*/
        //setup the pager below

        /*code below is to specifically disable shiftmode on bottom nav bar*/
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        /*simple code to fix the highlighting of the appropriate bottom nav icon when tapped, menu item index is set to '0' for first icon*/
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);


        /*below you will need to navigate to different areas when the nav buttons are pressed and you
          will need to use switch statements, breaks, and the code below */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_new_project:
                        Intent intent0 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_current_listings:
                        Intent intent1 = new Intent(MainActivity.this, Activity_Current_Listings.class);
                        startActivity(intent1);
                        break;


                    case R.id.ic_find_contractor:
                        Intent intent2 = new Intent(MainActivity.this, Activity_Find_Contractors.class);
                        startActivity(intent2);
                        break;


                    case R.id.ic_chat:
                        Intent intent3 = new Intent(MainActivity.this, Activity_Chat.class);
                        startActivity(intent3);

                        break;


                    case R.id.ic_settings:
                        Intent intent4 = new Intent(MainActivity.this, Activity_Settings.class);
                        startActivity(intent4);

                        break;
                }
                return false;
            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment1(), "Fragment1");
        adapter.addFragment(new Fragment2(), "Fragment2");
        adapter.addFragment(new Fragment3(), "Fragment3");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        mViewPager.setCurrentItem(fragmentNumber);
    }


    /*Testing git */



}