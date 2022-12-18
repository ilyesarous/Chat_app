package com.example.chatapp.data_base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.chatapp.module.user;

public class SqlProvider extends SQLiteOpenHelper {

    public SqlProvider( Context context) {
        super(context, "userDB", null, 1);
    }

    String createQuery = "create table users(" +
            "firstName text not null," +
            "lastName text not null," +
            "email text not null," +
            "password text not null);";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    public boolean insertData(user user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("firstName", user.getFirstName());
        values.put("lastName", user.getLastName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());

        long result = db.insert("users", null, values);
        return result != -1;
    }

    public boolean checkEmailPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean b;
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?",
                new String[] {email, password});
        b = cursor.getCount() > 0;
        cursor.close();
        return b;
    }

    public boolean checkUser(user user){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean b;
        Cursor cursor = db.rawQuery("select * from users where firstName=? and lastName=? and email=? and password=?",
                new String[] {user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword()});
        b = cursor.getCount() > 0;
        cursor.close();
        return b;
    }

    public String getName(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String req = "select * from users where email=\""+email+"\"";
        Cursor cursor = db.rawQuery(req, null);
        String fname = "";
        if (cursor.getCount() > 0){
            fname = cursor.getString(1);
        }
        cursor.close();
        return fname;
    }
}
