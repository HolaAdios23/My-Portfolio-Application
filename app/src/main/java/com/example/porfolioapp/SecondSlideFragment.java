package com.example.porfolioapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;


public class SecondSlideFragment extends Fragment {


   LinearLayout yellowsecond;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second_slide, container, false);

        yellowsecond = view.findViewById(R.id.yellowsecond);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);
        yellowsecond.startAnimation(animation);

        return view;
    }
}