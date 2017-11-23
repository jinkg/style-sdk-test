package com.yalin.style.engine.component;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * @author jinyalin
 * @since 2017/11/22.
 */

public class NativeFileHelper {

    private static final String TAG = "NativeFileHelper";
    private static String nativePath = null;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static File getNativeDir(Context context) {
        if (TextUtils.isEmpty(nativePath)) {
            File cacheDir = context.getCacheDir();
            File nativeDir = new File(cacheDir.getParent(), "files");
            nativeDir.mkdirs();
            nativePath = nativeDir.getAbsolutePath();
        }
        return new File(nativePath);
    }

    public static String getNativeFileName(String componentPath, String libName) {
        return getNativeComponentPrefix(componentPath) + libName + ".so";
    }

    public static void clearNativeFiles(Context context, String componentPath) {
        ArrayList<File> files = getNativeFiles(context, componentPath);
        for (File file : files) {
            file.delete();
        }
    }

    private static String getNativeComponentPrefix(String componentPath) {
        return "plugin_" + componentPath.hashCode() + "_";
    }

    private static ArrayList<File> getNativeFiles(Context context, String componentPath) {
        String nativePrefix = getNativeComponentPrefix(componentPath);
        File[] allFiles = getNativeDir(context).listFiles();
        ArrayList<File> validFiles = new ArrayList<>();
        for (File file : allFiles) {
            if (file.getName().startsWith(nativePrefix)) {
                validFiles.add(file);
            }
        }
        return validFiles;
    }
}
