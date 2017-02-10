package com.petitchef.petitchef.views.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.petitchef.petitchef.utils.Constants;

/**
 * Created by Nicolas Girardot on 16/09/2016 for petitchef-android
 */
public class CustomEditText extends EditText {


    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        setTypeface(Constants.getMainFont());
    }

    public CustomEditText(Context context) {
        super(context);

        setTypeface(Constants.getMainFont());
    }
}
