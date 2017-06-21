package com.project.jebus.appsolar.model;

import java.io.Serializable;

/**
 * Created by jebus on 23/10/15.
 */
public class HeadersEntity implements Serializable {

    private String name;
    private String value;

    public HeadersEntity(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
