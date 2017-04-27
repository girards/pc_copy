package com.petitchef.petitchef.objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nicolasgirardot on 1/20/17.
 */
public class Recipe implements Serializable {

    private String pictureUrl;
    private String title;
    private String description;
    private ArrayList<Step> steps;

    public Recipe(String pictureUrl, String title, String description, ArrayList<Step> steps) {
        this.pictureUrl = pictureUrl;
        this.title = title;
        this.description = description;
        this.steps = steps;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }
}
