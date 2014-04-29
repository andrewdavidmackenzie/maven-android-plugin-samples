package com.simpligility.android.morseflash;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * This is just a rough custom view that is used to test the ability to test such classes from an AndroidTestCase or ActivityInstrumentationTestCase2
 */
public class MorseFlashCustomView extends FrameLayout {
    public MorseFlashCustomView(Context context) {
        super(context);
    }

    public MorseFlashCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MorseFlashCustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void initUI(final Context context) {
        // Inflate the custom view
        View view = inflate(context, R.layout.morseflash, null);
        addView(view);
    }
}
