package com.lucas.jetpackdemo.databases;

import androidx.room.Room;
import com.lucas.jetpackdemo.MyApplication;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/17
 * Description:
 */
public class DBInstance{
    private static final String DB_NAME = "sample.db";
    private static UserDataBases INSTANCE;

    public static UserDataBases getInstance(){
        if(INSTANCE == null){
            synchronized (DBInstance.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(MyApplication.getContext(),UserDataBases.class,DB_NAME).build();
                }
            }
        }
        return INSTANCE;
    }
}
