package com.templateonetwo.testingtemplateonetwo;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import static android.graphics.Color.TRANSPARENT;

public class Fragment4_B2 extends android.support.v4.app.Fragment implements Fragment1.OnVideoSelectedLister, Fragment1.OnPhotoSelectedLister, AdapterView.OnItemSelectedListener {



    private static final String Tag4b2 = "Fragment4_B2";
    private Button btnNavFrag4b2;
    private Button btnNexttoReview;

    Integer teal = 0x81ecec;

    public TextView mTimefield;

    public TextView mDatefield;
    public DatePickerDialog.OnDateSetListener mOnDateSetListener;

    public Fragment4_B2() {}

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
        View view = inflater.inflate(R.layout.fragment4_b2_layout_video_path, container, false);

        btnNavFrag4b2 = (Button) view.findViewById(R.id.btnNavFrag4b2);
        btnNexttoReview = (Button) view.findViewById(R.id.Next_ToReview);
        mTimefield = (TextView) view.findViewById(R.id.Timefield);
        mDatefield = (TextView) view.findViewById(R.id.Datefield);
        mDatefield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcalendar = Calendar.getInstance();
                int year = mcalendar.get(Calendar.YEAR);
                int month = mcalendar.get(Calendar.MONTH);
                int day = mcalendar.get(Calendar.DAY_OF_MONTH);
         //       Fragment Fragment4b2 = getActivity().getFragmentManager().findFragmentByTag("Fragment4_B2");
               // Fragment Fragment4b3 =  getSupportFragmentManager().findFragmentByTag("Fragment4_B3");//*setTargetFragment(Fragment4_B2.this.getClass(), 55)*/
                /*^^both might be a way to reference specific fragments (which is based from MainActivity) in the future   */


                DatePickerDialog dateDialog = new DatePickerDialog(

                          getContext(),   /*Eureka!!, this seems to work, but still need to learn more about this*/
                   //     setTargetFragment(Fragment3.this, 3),
                     //   (Fragment4_B2)getActivity().getSupportFragmentManager().getFragment(MainActivity,)
                        android.R.style.Theme_DeviceDefault_InputMethod,
                        mOnDateSetListener,
                        year, month, day);

                dateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                dateDialog.show();
            }
/*Theme_Holo_Dialog_MinWidth*/
        });

        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1; /*Since Jan = 0, Dec = 11, etc. so we have to fix due to Java */
            Log.d(Tag4b2, "onDataSet: mm/dd/yyyy: " + month + "/" + dayOfMonth + "/" + year);
            String datefield4b2 = month + "/" + dayOfMonth + "/" + year;
            mDatefield.setText(datefield4b2);
            }
        };


        Log.d(Tag4b2, "onCreateView: started.");



    /*For fragments, contextually, you are "in" an activity already, so you don't traditionally
      navigate to other 'activities', you have to 'getActivity'as seen below*/

    //* button 4b placeholder *//
        btnNavFrag4b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 4B1", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).setViewPager(4);
            }
        });

        btnNexttoReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 4B3", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).setViewPager(6);
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

    }

    @Override
    public void getImagePath(Uri imagePath) {
    }

    @Override
    public void getImageBitmap(Bitmap bitmap) {
    }
}



/* extra junk code to test/play with
        Bitmap bmThumbnail = createVideoThumbnail(String.valueOf(mOnVideoSelectedLister), MediaStore.Images.Thumbnails.MINI_KIND);
        /*   viewImage.setImageBitmap(bmThumbnail); */

