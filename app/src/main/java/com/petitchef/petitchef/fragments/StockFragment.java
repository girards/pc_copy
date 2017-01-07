package com.petitchef.petitchef.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.petitchef.petitchef.App;
import com.petitchef.petitchef.R;
import com.petitchef.petitchef.objects.StockItem;
import com.petitchef.petitchef.views.adapters.StockListViewAdapter;

import java.util.ArrayList;

/**
 * Created by Nicolas Girardot on 17/09/2016 for petitchef-android
 */
public class StockFragment extends Fragment {

    private static final String TAG = "StockFragment";
    Tracker mTracker;

    private ListView stockListView;

    public static StockFragment newInstance() {
        StockFragment fragment = new StockFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock, container, false);
        final ArrayList<StockItem> stocks = new ArrayList<>();

        mTracker = App.getInstance().getDefaultTracker();


        StockListViewAdapter adapter = new StockListViewAdapter(this.getContext(), stocks);

        stockListView = (ListView) view.findViewById(R.id.stock_list_view);
        stockListView.setAdapter(adapter);
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
