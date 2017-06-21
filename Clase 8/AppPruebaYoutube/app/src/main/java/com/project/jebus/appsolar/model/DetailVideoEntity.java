package com.project.jebus.appsolar.model;

import java.io.Serializable;

/**
 * Created by jebus on 1/02/16.
 */
public class DetailVideoEntity implements Serializable {

    private String publishedAt;
    private String title;
    private String description;
    private ImageVideoEntity thumbnails;
    private String channelTitle;

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageVideoEntity getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(ImageVideoEntity thumbnails) {
        this.thumbnails = thumbnails;
    }
}
