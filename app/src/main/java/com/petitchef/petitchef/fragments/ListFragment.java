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
import com.petitchef.petitchef.objects.ListItem;
import com.petitchef.petitchef.views.adapters.ListListViewAdapter;

import java.util.ArrayList;

/**
 * Created by Nicolas Girardot on 17/09/2016 for petitchef-android
 */
public class ListFragment extends Fragment {

    private static final String TAG = "ListFragment";
    private ListView listListView;
    Tracker mTracker;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<ListItem> items = new ArrayList<>();

        ListListViewAdapter adapter = new ListListViewAdapter(this.getContext(), items);

        listListView  = (ListView) view.findViewById(R.id.list_list_view);
        listListView.setAdapter(adapter);
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
