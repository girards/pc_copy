package com.petitchef.petitchef.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.petitchef.petitchef.R;

/**
 * Created by Nicolas Girardot on 17/09/2016 for petitchef-android
 */
public class StockFragment extends Fragment {

    public static StockFragment newInstance() {
        StockFragment fragment = new StockFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock, container, false);
        return view;
    }
}
