package com.lucas.jetpackdemo.activity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.lucas.jetpackdemo.R;
import com.lucas.jetpackdemo.bean.User;
import com.lucas.jetpackdemo.databinding.ActivityViewmodelBinding;
import com.lucas.jetpackdemo.modelview.ViewModelActivityModel;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/17
 * Description:
 */
public class ViewModelActivity extends AppCompatActivity{

    ActivityViewmodelBinding mBinding;
    private ViewModelActivityModel modelActivityModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel);
        modelActivityModel = ViewModelProviders.of(this).get(ViewModelActivityModel.class);
        modelActivityModel.userMutableLiveData.observe(this, new Observer<User>(){

            @Override
            public void onChanged(User user){

                mBinding.tvName.setText("姓名： " + user.name + " 年龄： " + user.age);
            }
        });
        mBinding.tvBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                modelActivityModel.process();
            }
        });
    }
}
