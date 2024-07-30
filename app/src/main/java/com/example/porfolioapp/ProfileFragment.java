package com.example.porfolioapp;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;


public class ProfileFragment extends Fragment {



    private static final int REQUEST_CODE = 22;
    ShapeableImageView profile_image;
    View camera_btn;
    CardView account_view;
    CardView location_view;
    CardView gmail_view;

    CardView facebook_view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        camera_btn = view.findViewById(R.id.camera_profile);
        account_view = view.findViewById(R.id.account_url);
        location_view = view.findViewById(R.id.location_url);
        gmail_view = view.findViewById(R.id.gmail_url);
        facebook_view = view.findViewById(R.id.gallery_url);
        String location_String = "https://www.google.com/maps/place/Gothatar,+44600/@27.7039454,85.3726039,15.46z/data=!4m6!3m5!1s0x39eb1a4b8130dee1:0x7583aa0e523025f2!8m2!3d27.7015916!4d85.3807886!16s%2Fm%2F04jm1wx?entry=ttu";
        String instagram_String = "https://www.instagram.com/rez1_majhakoti";
        String facebook_String = "https://www.facebook.com/profile.php?id=100076658250160";
        String gmail_String = "https://mail.google.com/mail/u/0/#inbox?compose=GTvVlcRzCMjtddNXMWCNtVlLTmHwNldntBXxwDMzXJVRkRlHjWpDpqKnWGDFWNhPtGrcRhhpQKHJL";
        camera_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent image_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(image_intent, REQUEST_CODE);

                            }
        });

        gmail_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmail_intent = new Intent(Intent.ACTION_VIEW, Uri.parse(gmail_String));
                startActivity(gmail_intent);
            }
        });
        facebook_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebook_intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebook_String));
                startActivity(facebook_intent);
            }
        });
        account_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent instagram_intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagram_String));
               startActivity(instagram_intent);
            }
        });

        location_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent location_intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location_String));
                startActivity(location_intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        profile_image = getActivity().findViewById(R.id.profile_image);


        if(requestCode == REQUEST_CODE)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            profile_image.setImageBitmap(photo);
        }





    }
}