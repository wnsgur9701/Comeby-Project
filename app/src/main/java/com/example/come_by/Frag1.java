package com.example.come_by;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


public class Frag1 extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag1, container, false);

        ViewPager viewPager = (ViewPager) getView().findViewById(R.id.viewPager);
        viewPager.setAdapter(new ImageAdapter(getActivity()));


        return view;

    }

}
