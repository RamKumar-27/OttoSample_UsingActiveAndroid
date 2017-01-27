package com.otto.hp_pc.ottosample;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by HP-PC on 24-01-2017.
 */

public class MyApplication extends Application {
    private static Bus sBus;

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    public static Bus getBusInstance() {
        if (sBus == null)
            sBus = new Bus();
        return sBus;
    }

}
