package com.petitchef.petitchef;

import android.app.Application;
import android.content.Context;

/**
 * Created by girard_s on 11/05/2016 for PetitChef
 */
public class ApplicationExt extends Application {
    private static ApplicationExt instance;

    public static ApplicationExt getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
