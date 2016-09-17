package com.petitchef.petitchef.views.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Nicolas Girardot on 16/09/2016 for petitchef-android
 */
public class CustomTextView extends TextView {
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "AvenirNextCondensed-Regular.ttf");
        setTypeface(typeface);
    }
}
