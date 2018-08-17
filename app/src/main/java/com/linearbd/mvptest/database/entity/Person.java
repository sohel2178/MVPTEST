package com.linearbd.mvptest.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.linearbd.mvptest.database.converter.DateConverter;

import java.util.Date;

@Entity(tableName = "people")
@TypeConverters(DateConverter.class)
public class Person {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String address;
    public Date birthday;
    public String phone;
    public String email;


    @Ignore
    public Person() {
        this.name = "";
        this.address = "";
        this.birthday = null;
        this.phone = "";
        this.email = "";
    }


    public Person(String name, String address, Date birthday, String phone, String email) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }





}
