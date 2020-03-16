package com.lucas.jetpackdemo.modelview;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/16
 * Description:
 */
public class LiveDataModelView{
//    public Observable<String> name;
    private MutableLiveData<String> mCurrentName;
    private MutableLiveData<List<String>> mNameList;

//    public Observable<String> getName(){
//
//        return name;
//    }
//
//    public void setName(Observable<String> name){
//
//        this.name = name;
//
//    }



    public MutableLiveData<String> getCurrentName(){
        if(mCurrentName == null){
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }

    public MutableLiveData<List<String>> getNameList(){
        if(mNameList == null){
            mNameList = new MutableLiveData<>();
        }
        return mNameList;
    }
}
