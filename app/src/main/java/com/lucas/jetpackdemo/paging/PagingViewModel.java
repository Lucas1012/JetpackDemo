package com.lucas.jetpackdemo.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.lucas.jetpackdemo.databases.DBInstance;
import com.lucas.jetpackdemo.databases.User;
import com.lucas.jetpackdemo.databases.UserDao;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/4/18
 * Description:
 */
public class PagingViewModel extends ViewModel{

    public final LiveData<PagedList<User>> mPageList;
    public UserDao mUserDao;

    public PagingViewModel(){
        //配置页面数据
        PagedList.Config config = new PagedList.Config.Builder().setPageSize(30).setPrefetchDistance(150).build();
        this.mUserDao = DBInstance.getInstance().getUserDao();
        mPageList = new LivePagedListBuilder(mUserDao.concertsByDate(), config).build();
    }
}
