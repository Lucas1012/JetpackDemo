package com.lucas.jetpackdemo.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.lucas.jetpackdemo.R;
import com.lucas.jetpackdemo.databinding.ActivityLifecycleBinding;
import com.lucas.jetpackdemo.modelview.MyLifecycleObserver;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/16
 * Description:
 */
public class LifecycleActivity extends AppCompatActivity{
    ActivityLifecycleBinding mBinding;
    MyLifecycleObserver myLifecycleObserver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_lifecycle);
        myLifecycleObserver = new MyLifecycleObserver(getLifecycle());
        getLifecycle().addObserver(myLifecycleObserver);

    }

    @Override
    protected void onDestroy(){

        super.onDestroy();

        getLifecycle().removeObserver(myLifecycleObserver);
    }


}
