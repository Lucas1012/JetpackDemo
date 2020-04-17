package com.lucas.jetpackdemo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.lucas.jetpackdemo.R;
import com.lucas.jetpackdemo.databases.DBInstance;
import com.lucas.jetpackdemo.databases.User;
import com.lucas.jetpackdemo.databinding.ActivityRoomBinding;

import java.util.List;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/17
 * Description:
 */
public class RoomActivity extends AppCompatActivity{

    ActivityRoomBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_room);

        mBinding.tvBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                new Thread(){

                    @Override
                    public void run(){

                        super.run();
//                        for(int i=0;i<5;i++){
//                            DBInstance.getInstance().getUserDao().insertUser(new User("张三" + i,"" + i ,"11/22"));
//                        }
                        Log.d("dd","-----------------" + DBInstance.getInstance().getUserDao().QueryUsers().toString());
                    }
                }.start();

            }
        });
        mBinding.tvBtn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                new Thread(){

                    @Override
                    public void run(){

                        super.run();
                        List<User> users = DBInstance.getInstance().getUserDao().QueryUsers();
                        if(users != null && !users.isEmpty()){
                            Log.d("dd","----------------" + users.toString());
                            Message message = mHandler.obtainMessage();
                            message.what = 1;
                            message.obj = users.get(0);
                            mHandler.sendMessage(message);
                              }
                    }
                }.start();

            }
        });
//        if(DBInstance.getInstance().getUserDao() == null){
//            Toast.makeText(this, "dao null", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this, "dao not null", Toast.LENGTH_SHORT).show();
//        }

    }

    Handler mHandler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg){

            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    User user = (User)msg.obj;
                    mBinding.tvName.setText("ID： "+user.mUserId + "  姓名： " + user.mUserName + " 日期： " + user.mData);
                    break;
                    default:
                        break;
            }
        }
    };
}
