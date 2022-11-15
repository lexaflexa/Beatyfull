package com.lexass.aaaaaaaaaaaaa;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Beauty {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name" )
    public String name;

    @ColumnInfo(name = "beauty_name" )
    public String beauty_name;

    @ColumnInfo(name = "client")
    public String client;

    public Beauty(long iud, String name, String beauty_name, String client){
        this.uid = uid;
        this.beauty_name = beauty_name;
        this.name = name;
        this.client = client;

    }

    public int getUid() {return uid;}

    public void setUid(int uid) {this.uid = uid;}

    public String getBeauty_name() {
        return beauty_name;
    }

    public void setBeauty_name(String beauty_name) {
        this.beauty_name = beauty_name;
    }

    public String getName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }



}