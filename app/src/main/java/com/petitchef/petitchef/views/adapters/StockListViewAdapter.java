package com.petitchef.petitchef.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.petitchef.petitchef.R;
import com.petitchef.petitchef.objects.StockItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by girard_s on 03/12/2016 for petitchef-android
 */

public class StockListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<StockItem> mDataSource;
    private LayoutInflater mInflater;

    public StockListViewAdapter(Context context, ArrayList<StockItem> items) {
        mContext = context;
        mDataSource = items;
        mInflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public StockItem getItem(int i) {
        return mDataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = mInflater.inflate(R.layout.stock_element_view, viewGroup, false);

        Picasso.with(mContext).load(getItem(i).getPictureUrl()).into((ImageView) view.findViewById(R.id.stock_elem_img));
        
        return rowView;
    }
}
