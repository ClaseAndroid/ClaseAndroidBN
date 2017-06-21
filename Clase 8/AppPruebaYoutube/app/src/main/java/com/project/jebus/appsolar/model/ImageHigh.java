package com.project.jebus.appsolar.model;

import java.io.Serializable;

/**
 * Created by jebus on 1/02/16.
 */
public class ImageHigh implements Serializable {

    private String url;
    private double width;
    private double height;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
