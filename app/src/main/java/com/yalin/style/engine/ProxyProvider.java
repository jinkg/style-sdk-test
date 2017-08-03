package com.yalin.style.engine;

import android.content.Context;
import android.service.wallpaper.WallpaperService;

import com.yalin.style.sdk.test.ConfigReader;

/**
 * @author jinyalin
 * @since 2017/8/3.
 */

public class ProxyProvider {
    public WallpaperService provideProxy(Context host) {
        String[] info = ConfigReader.getComponentInfo();
        return ProxyApi.getProxy(host, info[0], info[1]);
    }
}
