package com.templateonetwo.testingtemplateonetwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment4_A1 extends android.support.v4.app.Fragment {
    private static final String Tag = "Fragment4_A1";

    private Button btnNavFrag1;
    private Button btnNavFrag2;
    private Button btnNavFrag3;
    private Button btnNavFrag4;
    private Button btnNavSecondActivity;


    /*below is auto-generate code from right clicking and inserting 'OnCreateView', this method
    is specific to Fragments vs. 'OnCreate' which is just for activities.
    You also have to create View objects and return at the bottom of onCreateView
     Deleted the 'super return...' code line */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
             View view = inflater.inflate(R.layout.fragment4_a1_layout_image_path, container, false);
             btnNavFrag1 = (Button) view.findViewById(R.id.btnNavFrag1); /*must use 'view' for fragments as opposed to not specifying like for normal activity */
             btnNavFrag2 = (Button) view.findViewById(R.id.btnNavFrag2);
             btnNavFrag3 = (Button) view.findViewById(R.id.btnNavFrag3);
             btnNavFrag4 = (Button) view.findViewById(R.id.btnNavFrag4);
             btnNavSecondActivity = (Button) view.findViewById(R.id.btnNavSecondActivity);
             Log.d(Tag, "onCreateView: started.");

            /*For fragments, contextually, you are "in" an activity already, so you don't traditionally
              navigate to other 'activities', you have to 'getActivity'as seen below*/

             btnNavFrag1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Toast.makeText(getActivity(), "Going to Fragment 1", Toast.LENGTH_SHORT).show();

                     ((MainActivity)getActivity()).setViewPager(0);
                     /*^^This code will allow you to access any method from the MainActivity, assuming
                      it is set to public. Also you set 'ViewPager' to 'int', so you must
                      follow android logic and put '0' as that references the starting page*/
                 }
             });

             btnNavFrag2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Going to Fragment 2", Toast.LENGTH_SHORT).show();
                    ((MainActivity)getActivity()).setViewPager(1);
                 }
             });

             btnNavFrag3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Going to Fragment 3", Toast.LENGTH_SHORT).show();
                    ((MainActivity)getActivity()).setViewPager(2);
                 }
             });

             btnNavFrag4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 5", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(3);
                }
             });

             btnNavSecondActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Going to Fragment 1", Toast.LENGTH_SHORT).show();
                    /* Use 'Intent' here since this is a activity you wish to navigate from*/
                    Intent intent = new Intent(getActivity(), SecondActivity.class);
                    startActivity(intent);
                 }
             });


             return view;

    }
}
