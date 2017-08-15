package com.yalin.style.engine;


import android.content.Context;

import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;

/**
 * @author jinyalin
 * @since 2017/7/28.
 */

public class GDXWallpaperServiceProxy extends AndroidLiveWallpaperService {
    public GDXWallpaperServiceProxy(Context host) {
        attachBaseContext(host);
    }

    @Override
    public Engine onCreateEngine() {
        return new GDXActiveEngine();
    }

    public class GDXActiveEngine extends AndroidWallpaperEngine {

    }
}
