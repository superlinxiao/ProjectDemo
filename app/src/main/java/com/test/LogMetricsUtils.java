package com.test;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * @author lizheng create at 2019/7/17 description:
 */
public class LogMetricsUtils {

    public static void logMetrics(Activity mActivity, String name) {
        // 系统的屏幕尺寸
        final DisplayMetrics systemDm = Resources.getSystem().getDisplayMetrics();
        // app整体的屏幕尺寸
        final DisplayMetrics appDm = mActivity.getApplication().getResources().getDisplayMetrics();
        // activity的屏幕尺寸
        final DisplayMetrics activityDm = mActivity.getResources().getDisplayMetrics();

        Log.e(
                "ShowMetrics",
                "name:"
                        + name
                        + "  systemDm:"
                        + systemDm
                        + "   appDm:"
                        + appDm
                        + "   activityDm:"
                        + activityDm);
    }
}
