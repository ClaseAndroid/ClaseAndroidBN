package com.capacitacion.project.appclase7.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jesus on 15/06/17.
 */

public class Friend implements Serializable {

    private String id;
    private String name;
    private String lastname;
    private String image;
    private String dni;
    private List<Friend> friendList;

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
