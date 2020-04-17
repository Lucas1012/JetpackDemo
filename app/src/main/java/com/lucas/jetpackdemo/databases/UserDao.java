package com.lucas.jetpackdemo.databases;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/17
 * Description:
 */
@Dao
public interface UserDao{

    @Query("select * from users")
    public List<User> QueryUsers();

    @Insert
    public void insertUser(User user);
}
