package com.lucas.jetpackdemo.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/16
 * Description:
 */
public class JetpackAdapter extends BaseAdapter{

    private Context mContext;
    private List<String> mData;

    public JetpackAdapter(Context mContext, List<String> mData){

        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount(){

        return mData == null ? 0 :mData.size();
    }

    @Override
    public Object getItem(int position){

        return mData.get(position);
    }

    @Override
    public long getItemId(int position){

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        TextView textView = new TextView(mContext);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        textView.setText(mData.get(position));
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(20,20,20,20);
        return textView;
    }
}
