package com.lucas.jetpackdemo.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/17
 * Description:
 */
@Database(entities = {User.class},version = 1,exportSchema = false)
//@TypeConverters(Converters.class)
public abstract class UserDataBases extends RoomDatabase{

    public abstract UserDao getUserDao();
}
