package com.yalin.style.sdk.test;

import android.content.Context;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.yalin.style.engine.component.NativeFileHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.yalin.style.sdk.test", appContext.getPackageName());
    }

    @Test
    public void testDeleteComponentSO() {
        String[] info = ConfigReader.getComponentInfo();
        Context appContext = InstrumentationRegistry.getTargetContext();
        NativeFileHelper.clearNativeFiles(appContext, info[0]);

        File nativeFile = new File(NativeFileHelper.getNativeDir(appContext).getAbsolutePath()
                + File.separator + NativeFileHelper.getNativeFileName(info[0], "libEarth"));
        assert !nativeFile.exists();
    }

}
