package com.lucas.jetpackdemo.modelview;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lucas.jetpackdemo.bean.User;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/17
 * Description:
 */
public class ViewModelActivityModel extends ViewModel{

    public MutableLiveData<User> userMutableLiveData = new MutableLiveData<User>();

    public ViewModelActivityModel(){
        //模拟从网络加载数据
        userMutableLiveData.setValue(new User("name1", 20));
    }

    public void process(){

        User user = userMutableLiveData.getValue();
        user.age = 120;
        user.name = "name3";
        userMutableLiveData.setValue(user);
    }
}
