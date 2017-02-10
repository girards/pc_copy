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
import com.petitchef.petitchef.objects.Recipe;
import com.petitchef.petitchef.views.adapters.RecipeListViewAdapter;

import java.util.ArrayList;

/**
 * Created by Nicolas Girardot on 17/09/2016 for petitchef-android
 */
public class RecipeFragment extends Fragment {

    private static final String TAG = "RecipeFragment";
    Tracker mTracker;

    private ListView recipeListView;

    public static RecipeFragment newInstance() {
        return new RecipeFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        mTracker = App.getInstance().getDefaultTracker();

        final ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("https://i.imgur.com/T9MSBoz.jpg", "FOOOD"));
        recipes.add(new Recipe("http://newtopwallpapers.com/wp-content/uploads/2013/04/HD-Rainbow-Picture-On-Beach.jpg", "FOOOD"));
        recipes.add(new Recipe("https://i.reddituploads.com/641b730db3a042d38593b418511fea87?fit=max&h=1536&w=1536&s=f06cd85a1eae33edb4fa2fa5c40f8ce9", "FOOOD"));
        recipes.add(new Recipe("http://newtopwallpapers.com/wp-content/uploads/2013/04/HD-Rainbow-Picture-On-Beach.jpg", "FOOOD"));
        recipes.add(new Recipe("http://newtopwallpapers.com/wp-content/uploads/2013/04/HD-Rainbow-Picture-On-Beach.jpg", "FOOOD"));
        recipes.add(new Recipe("https://i.reddituploads.com/641b730db3a042d38593b418511fea87?fit=max&h=1536&w=1536&s=f06cd85a1eae33edb4fa2fa5c40f8ce9", "FOOOD"));
        recipes.add(new Recipe("https://i.reddituploads.com/641b730db3a042d38593b418511fea87?fit=max&h=1536&w=1536&s=f06cd85a1eae33edb4fa2fa5c40f8ce9", "FOOOD"));
        recipes.add(new Recipe("https://i.reddituploads.com/641b730db3a042d38593b418511fea87?fit=max&h=1536&w=1536&s=f06cd85a1eae33edb4fa2fa5c40f8ce9", "FOOOD"));






        RecipeListViewAdapter adapter = new RecipeListViewAdapter(this.getContext(), recipes);
        recipeListView = (ListView) view.findViewById(R.id.recipe_list_view);
        recipeListView.setDividerHeight(0);
        recipeListView.setDivider(null);
        recipeListView.setAdapter(adapter);
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
