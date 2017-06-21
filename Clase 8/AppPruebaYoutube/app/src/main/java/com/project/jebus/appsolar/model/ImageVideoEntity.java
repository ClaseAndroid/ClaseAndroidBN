package com.project.jebus.appsolar.model;

import java.io.Serializable;

/**
 * Created by jebus on 1/02/16.
 */
public class ImageVideoEntity implements Serializable {

    private ImageMedium medium;
    private ImageHigh high;

    public ImageHigh getHigh() {
        return high;
    }

    public void setHigh(ImageHigh high) {
        this.high = high;
    }

    public ImageMedium getMedium() {
        return medium;
    }

    public void setMedium(ImageMedium medium) {
        this.medium = medium;
    }
}
