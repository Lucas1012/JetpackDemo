package com.lucas.jetpackdemo.modelview;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/16
 * Description:
 */
public class MyLifecycleObserver implements LifecycleObserver{

    private static final String TAG = "LiveDataObserver";
    private Lifecycle mLifeCycle;
    public MyLifecycleObserver(Lifecycle lifecycle){
        this.mLifeCycle = lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){

        Log.d(TAG,"---------------onCreate---------------");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){

        Log.d(TAG,"---------------onStart---------------");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        Log.d(TAG,"---------------onResume---------------");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestory(){
        Log.d(TAG,"---------------onDestory---------------");
    }

    public void enable(){
        //判断当前状态
        mLifeCycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED);{

        }
    }
}
