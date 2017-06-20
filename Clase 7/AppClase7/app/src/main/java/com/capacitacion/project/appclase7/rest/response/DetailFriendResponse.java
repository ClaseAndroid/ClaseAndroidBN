package com.capacitacion.project.appclase7.rest.response;

import com.capacitacion.project.appclase7.domain.Friend;

import java.util.List;

/**
 * Created by Jesus on 15/06/17.
 */

public class DetailFriendResponse {

    private String id;
    private String name;
    private String lastname;
    private String image;
    private String dni;
    private List<Friend> listfriends;

    public List<Friend> getListfriends() {
        return listfriends;
    }

    public void setListfriends(List<Friend> listfriends) {
        this.listfriends = listfriends;
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
