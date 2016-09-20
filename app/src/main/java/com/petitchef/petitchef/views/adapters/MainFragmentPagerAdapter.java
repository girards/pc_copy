package com.petitchef.petitchef.views.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.petitchef.petitchef.R;
import com.petitchef.petitchef.fragments.ListFragment;
import com.petitchef.petitchef.fragments.ProfileFragment;
import com.petitchef.petitchef.fragments.RecipeFragment;
import com.petitchef.petitchef.fragments.ScanFragment;
import com.petitchef.petitchef.fragments.StockFragment;

/**
 * Created by Nicolas Girardot on 17/09/2016 for petitchef-android
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 5;
    private String tabTitles[];
    private int[] imageResId = {R.drawable.stock_tab_icon,
                            R.drawable.recipes_tab_icon,
                            R.drawable.scan_tab_icon,
                            R.drawable.profile_tab_icon,
                            R.drawable.list_tab_icon};
    private Context context;

    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles = new String[] {context.getString(R.string.stock_title_tab),
                                context.getString(R.string.recipe_title_tab),
                                context.getString(R.string.scan_title_tab),
                                context.getString(R.string.profile_title_tab),
                                context.getString(R.string.list_title_tab)};
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                return StockFragment.newInstance();
            }
            case 1: {
                return RecipeFragment.newInstance();
            }
            case 2: {
                return ScanFragment.newInstance();
            }
            case 3: {
                return ProfileFragment.newInstance();
            }
            case 4: {
                return ListFragment.newInstance();
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    public View getTabView(int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab_view, null);
        TextView tv = (TextView) v.findViewById(R.id.tab_text);
        tv.setText(tabTitles[position]);
        tv.setTextColor(ContextCompat.getColor(context, R.color.flagWhite));
        ImageView img = (ImageView) v.findViewById(R.id.tab_image);
        img.setImageResource(imageResId[position]);
        if (position == 2){
            int color = ContextCompat.getColor(context, R.color.colorAccent);
            tv.setTextColor(color);
            img.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
        return v;
    }
}
