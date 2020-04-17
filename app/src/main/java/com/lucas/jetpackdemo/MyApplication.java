package com.lucas.jetpackdemo;

import android.app.Application;
import android.content.Context;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/17
 * Description:
 */
public class MyApplication extends Application{

    private static Context mContext;
    @Override
    public void onCreate(){

        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
