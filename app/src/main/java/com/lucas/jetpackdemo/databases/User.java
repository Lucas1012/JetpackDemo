package com.lucas.jetpackdemo.databases;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/17
 * Description:
 */

@Entity(tableName = "users")
public class User{

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "userId")
    public String mUserId;

    @ColumnInfo(name = "userName")
    public String mUserName;

    @ColumnInfo(name = "date")
    public String mData;

    @Ignore
    public User(String mUserName){

        this.mUserName = mUserName;
        mUserId = UUID.randomUUID().toString();
        mData = ""+System.currentTimeMillis();

    }

    public User(String mUserId, String mUserName, String mData){

        this.mUserId = mUserId;
        this.mUserName = mUserName;
        this.mData = mData;
    }
}
