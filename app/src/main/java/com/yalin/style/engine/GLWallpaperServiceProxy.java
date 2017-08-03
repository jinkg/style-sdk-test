package com.yalin.style.engine;

import android.content.Context;

import net.rbgrn.android.glwallpaperservice.GLWallpaperService;

/**
 * @author jinyalin
 * @since 2017/8/3.
 */

public class GLWallpaperServiceProxy extends GLWallpaperService {
    public GLWallpaperServiceProxy(Context host) {
        attachBaseContext(host);
    }

    public class GLActiveEngine extends GLEngine {
    }
}
