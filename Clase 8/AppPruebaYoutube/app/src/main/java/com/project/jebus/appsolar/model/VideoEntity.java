package com.project.jebus.appsolar.model;

import java.io.Serializable;

/**
 * Created by jebus on 1/02/16.
 */
public class VideoEntity implements Serializable {

    private IdVideoEntity id;
    private DetailVideoEntity snippet;

    public IdVideoEntity getId() {
        return id;
    }

    public void setId(IdVideoEntity id) {
        this.id = id;
    }

    public DetailVideoEntity getSnippet() {
        return snippet;
    }

    public void setSnippet(DetailVideoEntity snippet) {
        this.snippet = snippet;
    }
}
