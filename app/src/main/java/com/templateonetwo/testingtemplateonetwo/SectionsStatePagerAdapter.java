package com.templateonetwo.testingtemplateonetwo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/* you created a new class, then you 'extends' the 'FragementStatePagerAdapter' from the developer
 android site, once inputted, you will see it's red, click alt+enter and you can see what
  other prerequisite items you need, select all in the pop-up and click ok to see the new Override
  method placed. It will still be red, and once you hover over it again it will say it wants a default
  constructor, hit alt+enter again and click ok for the first option to select default constructor and
  click ok, an voila, you have generated all this automatically without typeing once.*/


/*after above is done we need to create two objects, one is an object for the list of the fragments,
and another is a list for the title of the fragments. */

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public SectionsStatePagerAdapter(FragmentManager fm) { super(fm); }

    /*This method is to actually add the fragments in the lists for the below Override methods*/
    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public Fragment getItem(int position) { return mFragmentList.get(position);}
        /*modified return 'null' to return 'mFragmentList.get(pos...)'*/
        /*we are simply returning the item in question at the position it is in */

    @Override
    public int getCount() { return mFragmentList.size();}


    /*we are simply returning the entire fragment list, instead of returning 0*/

}
