package com.petitchef.petitchef.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.petitchef.petitchef.App;
import com.petitchef.petitchef.R;

/**
 * Created by Nicolas Girardot on 17/09/2016 for petitchef-android
 */
public class StockFragment extends Fragment {

    private static final String TAG = "StockFragment";
    Tracker mTracker;

    public static StockFragment newInstance() {
        StockFragment fragment = new StockFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock, container, false);

        mTracker = App.getInstance().getDefaultTracker();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "Setting screen name: " +  TAG);
        mTracker.setScreenName("Image~" + TAG);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
