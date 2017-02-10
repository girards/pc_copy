package com.petitchef.petitchef.objects;

/**
 * Created by girard_s on 03/12/2016 for petitchef-android
 */
public class StockItem {

    private String pictureUrl;
    private String title;
    private String quantity;

    public StockItem(String url, String title, String quantity) {
        this.pictureUrl = url;
        this.title = title;
        this.quantity = quantity;
    }

    public String getPictureUrl(){
        return pictureUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getQuantity() {
        return quantity;
    }
}
