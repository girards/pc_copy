package com.petitchef.petitchef.views.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.petitchef.petitchef.R;
import com.petitchef.petitchef.objects.Recipe;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by nicolasgirardot on 1/20/17.
 */

public class RecipeListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Recipe> mDataSources;
    private LayoutInflater mInflater;

    public RecipeListViewAdapter(Context context, ArrayList<Recipe> recipes) {
        this.mContext = context;
        this.mDataSources = recipes;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSources.size();
    }

    @Override
    public Recipe getItem(int position) {
        return mDataSources.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View rowView = mInflater.inflate(R.layout.recipe_element_view, parent, false);


        Recipe item = getItem(position);

        Picasso.with(mContext).load(item.getPictureUrl())
                .into((ImageView) rowView.findViewById(R.id.recipe_elem_img), new Callback() {
                    @Override
                    public void onSuccess() {
                        placeTriangle(rowView.findViewById(R.id.recipe_elem_img),rowView.findViewById(R.id.test_view), position % 2);

                    }

                    @Override
                    public void onError() {

                    }
                });
        return rowView;
    }

    private void placeTriangle(final View mImageView, final View triangleView, final int isOdd) {
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                if (isOdd == 0) {
                    triangleView.setPivotX(0);
                    triangleView.setPivotY(0);
                }
                else {
                    triangleView.setPivotX(mImageView.getWidth());
                    triangleView.setPivotY(mImageView.getHeight());
                }
                float tanb = (float)mImageView.getHeight() / (float)mImageView.getWidth();

                Log.d("tan", "Width = " + mImageView.getWidth() + " ::: Height = " + mImageView.getHeight() + "  tan = " + tanb);

                triangleView.setRotation((float)Math.toDegrees(Math.atan(tanb)));
                ViewGroup.LayoutParams params =  triangleView.getLayoutParams();
                params.width = 2500;
                triangleView.setLayoutParams(params);
            }
        });
    }
}
