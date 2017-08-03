package com.yalin.style.sdk.test;

import android.os.Environment;

import org.json.JSONObject;

import java.io.File;
import java.util.Scanner;

/**
 * @author jinyalin
 * @since 2017/8/3.
 */

public class ConfigReader {
    private static final String STORE_PATH = "style";
    private static final String CONFIG_FILE_NAME = STORE_PATH + "/config.json";

    public static String[] getComponentInfo() {
        File file = new File(Environment.getExternalStorageDirectory(), CONFIG_FILE_NAME);
        String[] info = new String[2];
        try {
            String content = new Scanner(file).useDelimiter("\\Z").next();
            JSONObject configJson = new JSONObject(content);
            String componentName = configJson.optString("component_name");
            info[0] = new File(Environment.getExternalStorageDirectory(),
                    STORE_PATH + "/" + componentName).getAbsolutePath();
            info[1] = configJson.optString("provider_name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }
}
