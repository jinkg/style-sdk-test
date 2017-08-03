package com.yalin.style.sdk.test;

import android.service.wallpaper.WallpaperService;

import com.yalin.style.engine.ProxyProvider;

/**
 * @author jinyalin
 * @since 2017/8/3.
 */

public class StyleWallpaperService extends WallpaperService {
    private ProxyProvider proxyProvider = new ProxyProvider();

    private WallpaperService proxy;

    @Override
    public void onCreate() {
        super.onCreate();
        proxy = proxyProvider.provideProxy(this);
        if (proxy != null) {
            proxy.onCreate();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (proxy != null) {
            proxy.onDestroy();
        }
    }

    @Override
    public Engine onCreateEngine() {
        if (proxy != null) {
            return proxy.onCreateEngine();
        } else {
            return new Engine();
        }
    }
}
