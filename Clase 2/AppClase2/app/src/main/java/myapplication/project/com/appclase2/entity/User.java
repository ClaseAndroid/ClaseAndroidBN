package myapplication.project.com.appclase2.entity;

import java.io.Serializable;

/**
 * Created by Jesus Castro on 31/05/17.
 */

public class User implements Serializable{

    private String name;
    private String lastName;
    private String email;
    private String password;

    public User(String email, String password, String name, String lastName){
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
