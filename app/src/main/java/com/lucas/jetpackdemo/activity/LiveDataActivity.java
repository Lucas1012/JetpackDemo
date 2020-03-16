package com.lucas.jetpackdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.lucas.jetpackdemo.R;
import com.lucas.jetpackdemo.databinding.ActivityLivedataBinding;
import com.lucas.jetpackdemo.livedatabus.LiveDataBus;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/16
 * Description:
 */
public class LiveDataActivity extends AppCompatActivity{

    private static final String TAG = "LiveDataActivity";
    private ActivityLivedataBinding mBinding;
    //定义livedata
    private MutableLiveData<String> mName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_livedata);
        mName = new MutableLiveData<>();
        mName.setValue("张三");
        //注册观察者
        mName.observe(this,new Observer<String>(){

            @Override
            public void onChanged(String s){

                Log.d(TAG,"---------------onChanged-------------");
                mBinding.tvName.setText(s);
            }
        });
        mBinding.tvBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //修改livedata值，通知刷新
//                mName.setValue("change Name ：李四");
                new Thread(){

                    @Override
                    public void run(){

                        super.run();
                        LiveDataBus.get().with("name").postValue("LiveDataBus Changed ：王五");
                    }
                }.start();

            }
        });

        //LiveDataBus
        LiveDataBus.get().with("name",String.class).observe(this, new Observer<String>(){

            @Override
            public void onChanged(String s){
                mBinding.tvName.setText(s);
            }
        });

    }
}
