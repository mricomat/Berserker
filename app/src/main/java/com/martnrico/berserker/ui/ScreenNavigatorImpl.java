package com.martnrico.berserker.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.martnrico.berserker.di.ActivityScope;

import javax.inject.Inject;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
@ActivityScope
public class ScreenNavigatorImpl implements ScreenNavigator{

    @Inject
    ScreenNavigatorImpl() {

    }

    @Override
    public void navigateToActivity(Activity activityLaunching, Class classToStartIntent,
                                          Bundle extras, boolean removePreviousActivity) {
        Intent intent = createIntent(activityLaunching.getApplicationContext(), classToStartIntent, extras);
        performNavigationToActivity(activityLaunching, intent, 0, removePreviousActivity);
    }

    private static Intent createIntent(Context context, Class classToStartIntent, Bundle extras) {
        Intent intent = new Intent(context, classToStartIntent);
        if (extras != null) {
            intent.putExtras(extras);
        }
        return intent;
    }

    private static void performNavigationToActivity(Activity activityLaunching, Intent intent,
                                                    int requestCode, boolean removePreviousActivity) {
        if (activityLaunching != null) {
            if (requestCode > 0) {
                activityLaunching.startActivityForResult(intent, requestCode);
            } else {
                activityLaunching.startActivity(intent);
            }
        }
        if (removePreviousActivity) {
            assert activityLaunching != null;
            activityLaunching.finish();
        }
    }
}
