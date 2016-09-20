package com.petitchef.petitchef;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.petitchef.petitchef.views.adapters.MainFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        MainFragmentPagerAdapter adapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }

        TabLayout.Tab tab = tabLayout.getTabAt(2);
        tab.select();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ImageView iv = (ImageView) tab.getCustomView().findViewById(R.id.tab_image);
                TextView tv = (TextView) tab.getCustomView().findViewById(R.id.tab_text);
                int color = ContextCompat.getColor(MainActivity.this, R.color.colorAccent);
                tv.setTextColor(color);
                iv.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ImageView iv = (ImageView) tab.getCustomView().findViewById(R.id.tab_image);
                TextView tv = (TextView) tab.getCustomView().findViewById(R.id.tab_text);
                tv.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.flagWhite));
                iv.setColorFilter(R.color.flagWhite, PorterDuff.Mode.DST);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
