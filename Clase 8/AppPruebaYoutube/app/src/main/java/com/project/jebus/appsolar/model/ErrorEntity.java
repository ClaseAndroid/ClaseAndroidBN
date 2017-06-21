package com.project.jebus.appsolar.model;

import java.io.Serializable;

/**
 * Created by jebus on 19/01/16.
 */
public class ErrorEntity implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
