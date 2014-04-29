/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.simpligility.android.morseflash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static java.lang.Thread.sleep;

/**
 * Make sure that the main launcher activity opens up properly, which will be
 * verified by {@link android.test.ActivityInstrumentationTestCase#testActivityTestCaseSetUpProperly}.
 */
public class MorseViewTest extends ActivityInstrumentationTestCase2<ConfigureMorseActivity> {

    /**
     * The first constructor parameter must refer to the package identifier of the
     * package hosting the activity to be launched, which is specified in the AndroidManifest.xml
     * file.  This is not necessarily the same as the java package name of the class - in fact, in
     * some cases it may not match at all.
     */
    public MorseViewTest() {
        super("com.simpligility.android.morseflash", ConfigureMorseActivity.class);
    }

    @LargeTest
    public void testCustomView() throws Exception {
        startActivitySync(ConfigureMorseActivity.class);
        Instrumentation instrumentation = getInstrumentation();

        sleep(500); // robotium provides neater ways of waiting for the activity to initialise

        // Create a custom view, using the context of the app under test so that it can find it's
        // layout resources
        MorseFlashCustomView customView = new MorseFlashCustomView(instrumentation.getTargetContext());

        assertNotNull(customView);
    }

    private <T extends Activity> T startActivitySync(Class<T> clazz) {
        Intent intent = new Intent(getInstrumentation().getTargetContext(), clazz);
        intent.setFlags(intent.getFlags() | FLAG_ACTIVITY_NEW_TASK);
        return (T) getInstrumentation().startActivitySync(intent);
    }

}