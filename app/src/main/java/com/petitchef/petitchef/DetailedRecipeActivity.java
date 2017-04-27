package com.petitchef.petitchef;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.petitchef.petitchef.objects.Recipe;
import com.petitchef.petitchef.views.adapters.StepsAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by nicolasgirardot on 2/24/17.
 */

public class DetailedRecipeActivity extends AppCompatActivity {

    private Recipe selectedRecipe;
    private TextView recipeTitleTextView;
    private ImageView recipeImageView;
    private TextView recipeDescriptionTextView;
    private RecyclerView recipeStepsRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_recipe);

        selectedRecipe = (Recipe) getIntent().getSerializableExtra("recipe");
        recipeTitleTextView = (TextView) findViewById(R.id.recipe_detailed_title);
        recipeImageView = (ImageView) findViewById(R.id.recipe_detailed_image);
        recipeDescriptionTextView = (TextView) findViewById(R.id.recipe_detailed_description);
        recipeStepsRecyclerView = (RecyclerView) findViewById(R.id.recipe_detailed_steps);

        recipeTitleTextView.setText(selectedRecipe.getTitle());
        Picasso.with(getApplicationContext()).load(selectedRecipe.getPictureUrl()).into(recipeImageView);
        recipeDescriptionTextView.setText(selectedRecipe.getDescription());
        StepsAdapter adapter = new StepsAdapter(selectedRecipe.getSteps(), getApplicationContext());
        recipeStepsRecyclerView.setAdapter(adapter);
        recipeStepsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recipeStepsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public boolean top;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


                if (top) {
                    int index = ((LinearLayoutManager)recipeStepsRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    recipeStepsRecyclerView.smoothScrollToPosition(index);

                } else {
                    int index = ((LinearLayoutManager)recipeStepsRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    recipeStepsRecyclerView.smoothScrollToPosition(index);
                }


            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dx > 0) {
                    top = false;
                } else {

                    top = true;
                }

            }
        });
    }
}
