package com.lucas.jetpackdemo.workmanager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.work.*;
import com.lucas.jetpackdemo.R;
import com.lucas.jetpackdemo.databinding.ActivityWorkmanagerBinding;

import java.util.concurrent.TimeUnit;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/4/17
 * Description:
 */
public class WorkManagerActivity extends AppCompatActivity{

    private static final String TAG = "WorkManagerActivity";
    ActivityWorkmanagerBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_workmanager);
        mBinding.tvStartwork.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Toast.makeText(WorkManagerActivity.this, "启动任务", Toast.LENGTH_SHORT).show();
                startWork();
            }
        });
    }

    private void startWork(){
//设置约束条件
        Constraints constraints =  new Constraints.Builder().setRequiresCharging(false).setRequiresDeviceIdle(false).build();
        //初始化一次执行任务项
        OneTimeWorkRequest request1 = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        OneTimeWorkRequest request2 = new OneTimeWorkRequest.Builder(MyWorker2.class).build();
        OneTimeWorkRequest request3 = new OneTimeWorkRequest.Builder(MyWorker3.class).build();
        //初始化定时执行任务项
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWorker.class,5, TimeUnit.SECONDS).addTag("work").build();

        //设置结果接收
        WorkManager.getInstance().getWorkInfoByIdLiveData(periodicWorkRequest.getId()).observe(this, new Observer<WorkInfo>(){

            @Override
            public void onChanged(WorkInfo workInfo){
                Log.d(TAG,"---------result ------------" + workInfo.getState());
            }
        });
        //执行一个任务
       // WorkManager.getInstance().enqueue(request1);
        //执行定时任务
//        WorkManager.getInstance().enqueue(periodicWorkRequest);
        //执行链式任务
    //    WorkManager.getInstance().beginWith(Arrays.asList(request1,request2)).then(request3).enqueue();
        //取消任务通过id
     //   WorkManager.getInstance().cancelWorkById(request1.getId());
        WorkManager.getInstance().beginUniqueWork("aaa",ExistingWorkPolicy.APPEND,request1);
    }

    /**
     * 定义任务1
     */
    public static class MyWorker extends Worker{
        public static  String PROGRESS = "PROGRESS";
        public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams){

            super(context, workerParams);

        }

        @NonNull
        @Override
        public Result doWork(){
            try{

                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            Log.d(TAG,"-------------执行任务----work1-------  " + Thread.currentThread().getName() );
            return Result.success();
        }
    }

    /**
     * 定义任务2
     */
    public static class MyWorker2 extends Worker{

        public MyWorker2(@NonNull Context context, @NonNull WorkerParameters workerParams){

            super(context, workerParams);
        }

        @NonNull
        @Override
        public Result doWork(){
            try{

                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            Log.d(TAG,"-------------执行任务----work2-------  " + Thread.currentThread().getName() );
            return Result.success();
        }
    }

    /**
     * 定义任务
     */
    public static class MyWorker3 extends Worker{

        public MyWorker3(@NonNull Context context, @NonNull WorkerParameters workerParams){

            super(context, workerParams);
        }

        @NonNull
        @Override
        public Result doWork(){
            try{

                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            Log.d(TAG,"-------------执行任务----work3-------  " + Thread.currentThread().getName() );
            return Result.success();
        }
    }
}
