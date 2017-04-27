package com.petitchef.petitchef.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.petitchef.petitchef.App;
import com.petitchef.petitchef.DetailedRecipeActivity;
import com.petitchef.petitchef.R;
import com.petitchef.petitchef.objects.Recipe;
import com.petitchef.petitchef.objects.Step;
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
        final ArrayList<Step> steps = new ArrayList<>();

        steps.add(new Step("https://upload.wikimedia.org/wikipedia/commons/2/2e/Fast_food_meal.jpg", "Commande Ta nouriture"));
        steps.add(new Step("http://cdn-img.health.com/sites/default/files/migration/images/slides/junk-food-400x400.jpg", "mange La nouriture"));
        steps.add(new Step("http://i.huffpost.com/gen/1445348/images/n-DIGESTION-PAIN-628x314.jpg", "Ta mal Mamene"));

        recipes.add(new Recipe("http://static.cuisineaz.com/680x357/i72081-bruschettas-tomates-olives-et-parmesan.jpg", "Bruschetta", getResources().getString(R.string.lorme_ipsum), steps));
        recipes.add(new Recipe("http://jimmytscatering.com/wp-content/uploads/2013/04/garlic-shrimp.jpg", "Crevettes aux noix", getResources().getString(R.string.lorme_ipsum), steps));
        recipes.add(new Recipe("http://regimea.com/wp-content/uploads/2014/10/les-lasagnes-font-elles-grossir-702x336.jpg", "Lasagnes", getResources().getString(R.string.lorme_ipsum), steps));

        RecipeListViewAdapter adapter = new RecipeListViewAdapter(this.getContext(), recipes);
        recipeListView = (ListView) view.findViewById(R.id.recipe_list_view);
        recipeListView.setDividerHeight(0);
        recipeListView.setDivider(null);
        recipeListView.setAdapter(adapter);
        recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailedRecipeActivity.class);
                intent.putExtra("recipe", recipes.get(position));
                startActivity(intent);
            }
        });
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
