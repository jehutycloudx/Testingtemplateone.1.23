package com.templateonetwo.testingtemplateonetwo;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.app.Activity.RESULT_OK;
import static android.media.ThumbnailUtils.createVideoThumbnail;
import static android.media.ThumbnailUtils.extractThumbnail;

public class Fragment4_B1 extends android.support.v4.app.Fragment implements Fragment1.OnVideoSelectedLister, Fragment1.OnPhotoSelectedLister, AdapterView.OnItemSelectedListener {



    private static final String Tag = "Fragment4_B1";
    private Button btnNavFrag4b;
   // static final int REQUEST_VIDEO_CAPTURE = 103;
   static final int REQUEST_IMAGE_CAPTURE = 104;
    public VideoView result_video;
    public Button mPlayButton;
    public ImageView bitmapthumbnail;

    public Intent videopath;
    private Uri mImageUri;
    private Bitmap mBitmap;
    private Spinner mSpinner;

    String[] CategoryNames={"General Fix", "Appliances","Brick, Concrete, & Stone", "Cleaning", "Drywall",
            "Electric", "Flooring", "Garage", "Junk Removal", "Kitchen",
            "Heating & Cooling", "Lawn & Yard work", "Painting",
            "Plumbing & Bathroom", "Remodeling", "Roofing & Gutters", "Siding",
            "Windows", "Other" };

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
        bitmapthumbnail = (ImageView) view.findViewById(R.id.bmThumbnail);
        Log.d(Tag, "onCreateView: started.");

        //Getting the instance of Spinner and applying OnItemSelectedListener on it

        mSpinner = (Spinner) view.findViewById(R.id.spinner2);
        mSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, CategoryNames);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mSpinner.setAdapter(LTRadapter);






            /*For fragments, contextually, you are "in" an activity already, so you don't traditionally
              navigate to other 'activities', you have to 'getActivity'as seen below*/


    //* button 4b placeholder *//
        btnNavFrag4b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Toast.makeText(getActivity(), "Going to Fragment 4B2", Toast.LENGTH_SHORT).show();
            ((MainActivity) getActivity()).setViewPager(5);
            }

        });

            return view;

            }

/*Needed for this class to implement spinner class methods in order to work*/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }






    public void setBitmapthumbnail(ImageView bitmapthumbnail) {
        this.bitmapthumbnail = bitmapthumbnail;

    }
/*configuration for camcorder setup 2, this code is if camera activity will happen on same screen, so am temporarily disabling
      as we need the code from Fragement 1 which is where camera activity is located */
  /*  @Override
    public void onActivityResult (int requestCode, int resultCode, Intent getVideopath){
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = getVideopath.getData(); /*this '.getData' function is just going to fetch where the data was stored*/
//            result_video.setVideoURI(videoUri);
//            Intent videoIntent = getVideopath;


        /*configuration for camcorder setup */
        /*configuration for camcorder setup 2, this code is if camera activity will happen on same screen, so am temporarily disabling
      as we need the code from Fragement 1 which is where camera activity is located */
//        mPlayButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//            }
//        });
//    }


    @Override
    public void getVideopath(Uri data) {

        Log.d(Tag, "setting video to imageview bitmapthumbnail");

/* 1) attempt*/   result_video.setVideoURI(data);

/* 2) attempt*/   //bitmapthumbnail = createVideoThumbnail(getString(getVideopath();)

    }

    @Override
    public void getImagePath(Uri imagePath) {
        Log.d(Tag, "setting image to imageview bitmapthumbnail");

        bitmapthumbnail.setImageURI(imagePath);
        mBitmap = null;
        mImageUri = imagePath;
       // setTargetFragment(this, 104);
    }



    @Override
    public void getImageBitmap(Bitmap bitmap) {
        Log.d(Tag, "setting image from gallery to bitmapthumbnail");

       bitmapthumbnail.setImageBitmap(bitmap);
       mImageUri = null;
       mBitmap = bitmap;

    }
}



/* extra junk code to test/play with
        Bitmap bmThumbnail = createVideoThumbnail(String.valueOf(mOnVideoSelectedLister), MediaStore.Images.Thumbnails.MINI_KIND);
        /*   viewImage.setImageBitmap(bmThumbnail); */

