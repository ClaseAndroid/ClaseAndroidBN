package com.capacitacion.project.appclase5.model;

import java.io.Serializable;

/**
 * Created by jebus on 02/04/2016.
 */
public class VersionAndroidEntity implements Serializable {

    private String nameVersion;
    private int imageVersion;

    public VersionAndroidEntity(String nameVersion, int imageVersion){
        this.nameVersion = nameVersion;
        this.imageVersion = imageVersion;
    }

    public String getNameVersion() {
        return nameVersion;
    }

    public void setNameVersion(String nameVersion) {
        this.nameVersion = nameVersion;
    }

    public int getImageVersion() {
        return imageVersion;
    }

    public void setImageVersion(int imageVersion) {
        imageVersion = imageVersion;
    }
}
