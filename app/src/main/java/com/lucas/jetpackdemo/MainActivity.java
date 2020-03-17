package com.lucas.jetpackdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.lucas.jetpackdemo.activity.LifecycleActivity;
import com.lucas.jetpackdemo.activity.LiveDataActivity;
import com.lucas.jetpackdemo.activity.ViewModelActivity;
import com.lucas.jetpackdemo.adapter.JetpackAdapter;
import com.lucas.jetpackdemo.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    public ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.jetpack));
        JetpackAdapter jetpackAdapter = new JetpackAdapter(this, list);
        mBinding.lvList.setAdapter(jetpackAdapter);
        mBinding.lvList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                toJetpack(position);
            }
        });
    }

    private void toJetpack(int position){
        switch (position){
            case 0:
                break;
            case 1:
                Intent intent1 = new Intent(MainActivity.this, LifecycleActivity.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(MainActivity.this, LiveDataActivity.class);
                startActivity(intent2);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                Intent intent6 = new Intent(MainActivity.this, ViewModelActivity.class);
                startActivity(intent6);
                break;
            case 7:
                break;
                default:
                    break;
        }
    }
}
