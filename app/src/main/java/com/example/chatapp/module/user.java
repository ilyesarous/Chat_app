package com.example.chatapp.module;


import java.io.Serializable;

public class user implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public user(String firstName, String lastName, String email, String password){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }



}
