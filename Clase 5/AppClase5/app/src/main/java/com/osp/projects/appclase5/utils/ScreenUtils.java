package com.osp.projects.appclase5.utils;

import android.content.res.Resources;


public class ScreenUtils {

    public ScreenUtils() {
    }

    public static int dpToPx(int dp) {
        return (int)((float)dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
