package com.petitchef.petitchef.objects;

/**
 * Created by nicolasgirardot on 1/20/17.
 */
public class Recipe {

    private String pictureUrl;
    private String title;

    public Recipe(String pictureUrl, String title) {
        this.pictureUrl = pictureUrl;
        this.title = title;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getTitle() {
        return title;
    }
}
