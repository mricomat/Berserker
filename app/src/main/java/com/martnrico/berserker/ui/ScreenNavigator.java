package com.martnrico.berserker.ui;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
public interface ScreenNavigator {

    void navigateToActivity(Activity activityLaunching, Class classToStartIntent,
                       Bundle extras, boolean removePreviousActivity);
}
