package com.petitchef.petitchef.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.petitchef.petitchef.R;
import com.petitchef.petitchef.objects.ListItem;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nicolasgirardot on 1/27/17.
 */

public class ListListViewAdapter extends BaseAdapter implements Serializable {

    private ArrayList<ListItem> items;
    private Context mContext;
    private LayoutInflater mInflater;

    public ListListViewAdapter(Context context, ArrayList<ListItem> items) {
        this.mContext = context;
        this.items = items;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ListItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.list_element_view, parent, false);

        ListItem item  = getItem(position);
        return rowView;
    }
}
