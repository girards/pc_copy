package com.petitchef.petitchef;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.onesignal.OneSignal;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.petitchef.petitchef.utils.Constants;

/**
 * Created by girard_s on 11/05/2016 for PetitChef
 */
public class App extends Application {
    private static App instance;
    private Tracker mTracker;

    public static App getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
        Constants.mainFont = Typeface.createFromAsset(getContext().getAssets(), "AvenirNextCondensed-Regular.ttf");

        //Fabric.with(this, new Crashlytics());
        OneSignal.startInit(this).init();
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker("UA-85070628-1");
        }
        return mTracker;
    }
}
