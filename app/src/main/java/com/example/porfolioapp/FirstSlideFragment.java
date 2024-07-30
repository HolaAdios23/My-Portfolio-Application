package com.example.porfolioapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;


public class FirstSlideFragment extends Fragment {

      LinearLayout yellow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_slide, container, false);

        yellow = view.findViewById(R.id.yellownow);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);
        yellow.startAnimation(animation);


        return view;
    }
}