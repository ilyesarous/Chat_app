package com.example.chatapp.controller;


import android.content.Context;

import com.example.chatapp.data_base.SqlProvider;
import com.example.chatapp.module.user;


public class Controller {

    private static Controller instance = null;
    private static user profil;


    private Controller(){
        super();
    }

    public static Controller getInstance(Context context) {
        if(Controller.instance == null)
            Controller.instance = new Controller();
        return Controller.instance;
    }

    //public boolean createProfile(user user)

    //public boolean checkEmailPassword(String email, String password)
}
