package com.templateonetwo.testingtemplateonetwo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import static android.app.Activity.RESULT_OK;

public class Fragment4_B1 extends android.support.v4.app.Fragment {
    private static final String Tag = "Fragment4_B1";


    private Button btnNavFrag4b;
    static final int REQUEST_VIDEO_CAPTURE = 103;
    public VideoView result_video;
    public Button mPlayButton;



    /*below is auto-generate code from right clicking and inserting 'OnCreateView', this method
    is specific to Fragments vs. 'OnCreate' which is just for activities.
    You also have to create View objects and return at the bottom of onCreateView
     Deleted the 'super return...' code line */



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4_b1_layout_video_path, container, false);

        btnNavFrag4b = (Button) view.findViewById(R.id.btnNavFrag4b1);
        mPlayButton = (Button) view.findViewById(R.id.btnReplay);
        result_video = (VideoView) view.findViewById(R.id.videoView2);



        Log.d(Tag, "onCreateView: started.");

            /*For fragments, contextually, you are "in" an activity already, so you don't traditionally
              navigate to other 'activities', you have to 'getActivity'as seen below*/


                /* button 4b placeholder */
                btnNavFrag4b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(), "Going to Fragment 5", Toast.LENGTH_SHORT).show();
                        ((MainActivity) getActivity()).setViewPager(4);
                    }
                });

                return view;

            }
    /*configuration for camcorder setup 2 */
    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent getVideopath){
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = getVideopath.getData(); /*this '.getData' function is just going to fetch where the data was stored*/
         //   result_video.setVideoURI(videoUri);

        }








        /*configuration for camcorder setup */
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
}



