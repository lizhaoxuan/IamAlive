package com.zhaoxuan.iamalive;

import android.app.Application;

/**
 * Created by lizhaoxuan on 16/1/25.
 */
public class AliveApplication extends Application {

    private static AliveApplication instance;

    public static AliveApplication getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
