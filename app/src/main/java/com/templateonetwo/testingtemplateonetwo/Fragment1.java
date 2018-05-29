package com.templateonetwo.testingtemplateonetwo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;


public class Fragment1 extends android.support.v4.app.Fragment {
    private static final String Tag = "Fragment1";

    private static final int VIDEO_FILE_REQUEST_CODE = 1111;
    private static final int CAMERA_FILE_REQUEST_CODE = 2222;
    private static final int PICK_FILE_REQUEST_CODE = 3333;

    /*Need interface to interact with Activityresults from camera photo/video and media upload */
    /*Lecture, 'Selecting an Image for Uploading' - Android Classifieds... */
    public interface OnPhotoSelectedLister {
        void getImagePath(Uri imagePath);

        void getImageBitmap(Bitmap bitmap);
    }

    public interface OnVideoSelectedLister {
        void getVideopath(Uri data);  //?????? maybe video is data here?
    }

    OnPhotoSelectedLister mOnPhotoSelectedLister;  //*maybe there is a video version of this*//
    public static VideoView mVideoview; /*just added this to make code work below */

    OnVideoSelectedLister mOnVideoSelectedLister;


    private Button btnNavFrag1;
    private Button btnNavFrag2;
    private Button btnNavFrag3;
    private Button btnNavFrag4;
    private Button btnNavFrag4b;
    private Button btnNavSecondActivity;
    private Button btnCameraVideo;
    private Button btnCameraImage;
    private Button btnMediaUpload;


    /*below is auto-generate code from right clicking and inserting 'OnCreateView', this method
    is specific to Fragments vs. 'OnCreate' which is just for activities.
    You also have to create View objects and return at the bottom of onCreateView
     Deleted the 'super return...' code line */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        btnNavFrag1 = (Button) view.findViewById(R.id.btnNavFrag1); /*must use 'view' for fragments as opposed to not specifying like for normal activity */
        btnNavFrag2 = (Button) view.findViewById(R.id.btnNavFrag2);
        btnNavFrag3 = (Button) view.findViewById(R.id.btnNavFrag3);
        btnNavFrag4 = (Button) view.findViewById(R.id.btnNavFrag4);
        btnNavFrag4b = (Button) view.findViewById(R.id.btnNavFrag4b1);
        btnNavSecondActivity = (Button) view.findViewById(R.id.btnNavSecondActivity);
        btnCameraVideo = (Button) view.findViewById(R.id.btnCameraVideo);
        btnCameraImage = (Button) view.findViewById(R.id.btnCameraImage);
        btnMediaUpload = (Button) view.findViewById(R.id.btnMediaUpload);

        Log.d(Tag, "onCreateView: started.");

            /*For fragments, contextually, you are "in" an activity already, so you don't traditionally
              navigate to other 'activities', you have to 'getActivity'as seen below*/

        btnNavFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 1", Toast.LENGTH_SHORT).show();

                ((MainActivity) getActivity()).setViewPager(0);
                     /*^^This code will allow you to access any method from the MainActivity, assuming
                      it is set to public. Also you set 'ViewPager' to 'int', so you must
                      follow android logic and put '0' as that references the starting page*/
            }
        });

        btnNavFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 2", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).setViewPager(1);
            }
        });

        btnNavFrag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 3", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).setViewPager(2);
            }
        });

        btnNavFrag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 4a1", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).setViewPager(3);
            }
        });

        btnNavFrag4b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 4b", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).setViewPager(4);
            }
        });


        btnNavSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Second Activity", Toast.LENGTH_SHORT).show();
                /* Use 'Intent' here since this is a activity you wish to navigate from*/
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });

        btnCameraVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Using Camera Video", Toast.LENGTH_SHORT).show();
                /* Use 'Intent' here since this is a activity you wish to navigate from*/
                Intent intentCamVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intentCamVideo, VIDEO_FILE_REQUEST_CODE);
            }

        });

        btnCameraImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Using Camera Image", Toast.LENGTH_SHORT).show();
                /* Use 'Intent' here since this is a activity you wish to navigate from*/
                Intent intentCamImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamImage, CAMERA_FILE_REQUEST_CODE);
            }
        });

        btnMediaUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Accessing Gallery", Toast.LENGTH_SHORT).show();
                /* Use 'Intent' here since this is a activity you wish to navigate from*/
                Intent intentMediaUpload = new Intent(Intent.ACTION_GET_CONTENT);
                intentMediaUpload.setType("image/*");
                startActivityForResult(intentMediaUpload, PICK_FILE_REQUEST_CODE);
            }
        });

        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /* Results when selecting a new image from memory*/
        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri selectedImageUri = data.getData();
            Log.d(Tag, "onActivityResult image uri: " + selectedImageUri);

            //Send the uri to PostFragment or Posting page/area
            mOnPhotoSelectedLister.getImagePath(selectedImageUri);
        }

        /* Results when taking a new photo/image from Camera*/
        else if (requestCode == CAMERA_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Log.d(Tag, "onActivity Result: done taking new photo");
            Bitmap bitmapimage;
            bitmapimage = (Bitmap) data.getExtras().get("data");

            //Send the bitmapimage to PostFragment or Posting page/area
            mOnPhotoSelectedLister.getImageBitmap(bitmapimage);

        }

        /* Results when taking a new video from Camera, filled in presumptions based on Android documentation*/
        /*Most likely will have to change as how video is handled here*/
        /*followed this: https://developer.android.com/training/camera/videobasics*/
        //start 'Camera Storage Permission Lecture'
        else if (requestCode == VIDEO_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri videoUri = data.getData();
            mVideoview.setVideoURI(videoUri);
            Log.d(Tag, "onActivity Result: done taking new video");

            //Send the videoUri to PostFragment or Posting page/area
            mOnVideoSelectedLister.getVideopath(videoUri);

        }
    }

    @Override
    public void onAttach(Context context) {
        try {
            mOnPhotoSelectedLister = (OnPhotoSelectedLister) getActivity();
        } catch (ClassCastException e) {
            Log.e(Tag, "OnAttach: ClassCastException: " + e.getMessage());
        }
         {


        }

        super.onAttach(context);
    }

}



