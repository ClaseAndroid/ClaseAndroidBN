package com.project.jebus.appsolar.ui.coreJebus;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by jebus on 02/01/2016.
 */
public class ScreenUtilsJebus {

    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px)
    {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static Point getDeviceDimention(Activity context)
    {
        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        float density = metrics.density;
        int densityDpi = metrics.densityDpi;

        Log.v("ScreenUtils", "widthPixels " + widthPixels + " heightPixels " + heightPixels + " density " + density + " densityDpi " + densityDpi);
        Point point = new Point(widthPixels,heightPixels);

        return point;
    }

    public  static Point getMidPoint(Point p1, Point p2)
    {
        return new Point(((p1.x+p2.x)/2),((p1.y+p2.y)/2));
    }

    public static float getCurrentDIP(Context context)
    {
        float d = context.getResources().getDisplayMetrics().density;
        return d;
    }

    public static DisplayInfo getCurrentInfo(Context context)
    {
        DisplayMetrics d = context.getResources().getDisplayMetrics();
        return new DisplayInfo(getDip(getCurrentDIP(context),d.widthPixels),
                getDip(getCurrentDIP(context),d.heightPixels));
    }


    public static  int getDip(float scale, int pixel)
    {
        return (int) (pixel * scale + 0.5f);
    }

    public  static  class DisplayInfo implements Serializable
    {
        private int width;
        private int height;


        public DisplayInfo(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

}
