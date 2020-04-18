package com.lucas.jetpackdemo.paging;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.lucas.jetpackdemo.R;
import com.lucas.jetpackdemo.databases.DBInstance;
import com.lucas.jetpackdemo.databases.User;
import com.lucas.jetpackdemo.databinding.ActivityPagingBinding;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/4/18
 * Description:
 */
public class PagingActivity extends AppCompatActivity{

    private ActivityPagingBinding mBinding;
    private PagingViewModel mPagingViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_paging);
        mPagingViewModel = ViewModelProviders.of(this).get(PagingViewModel.class);
        final UserAdapter userAdapter = new UserAdapter(this);
        mPagingViewModel.mPageList.observe(this, new Observer<PagedList<User>>(){

            @Override
            public void onChanged(final PagedList<User> users){

                userAdapter.submitList(users);
            }
        });
        mBinding.recclerview.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recclerview.setAdapter(userAdapter);
    }

    public void addData(View view){

        new Thread(){

            @Override
            public void run(){

                super.run();
                for (int i = 0; i < 50; i++){
                    DBInstance.getInstance().getUserDao().insertUser(new User( "张三" + i));
                }
            }
        }.start();
    }
}
