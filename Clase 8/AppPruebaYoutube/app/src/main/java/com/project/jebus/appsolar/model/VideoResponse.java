package com.project.jebus.appsolar.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jebus on 1/02/16.
 */
public class VideoResponse implements Serializable {

    private List<VideoEntity> items;

    public List<VideoEntity> getItems() {
        return items;
    }

    public void setItems(List<VideoEntity> items) {
        this.items = items;
    }
}
