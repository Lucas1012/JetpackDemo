package com.lucas.jetpackdemo.paging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.lucas.jetpackdemo.R;
import com.lucas.jetpackdemo.databases.User;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/4/18
 * Description:
 */
public class UserAdapter extends PagedListAdapter<User, UserAdapter.UserViewHolder>{

    private Context mContext;

    public UserAdapter(@NonNull Context context){

        super(DIFF_CALLBACK);
        this.mContext = context;
    }

    @Override
    public void submitList(PagedList<User> pagedList){

        super.submitList(pagedList);
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position){

        User user = getItem(position);
        if (user != null){
            holder.bindTo(user);
        }
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName, tv_id, tv_date;
        private View mRootView;

        public UserViewHolder(@NonNull View itemView){

            super(itemView);
            mRootView = itemView;
            tvName = mRootView.findViewById(R.id.tv_name);
            tv_id = mRootView.findViewById(R.id.tv_id);
            tv_date = mRootView.findViewById(R.id.tv_date);
        }

        public void bindTo(User user){

            tvName.setText(user.mUserName);
            tv_id.setText(user.mUserId);
            tv_date.setText(user.mData);
        }

        public void clear(){

        }

    }

    private static DiffUtil.ItemCallback<User> DIFF_CALLBACK =
        new DiffUtil.ItemCallback<User>(){

            @Override
            public boolean areItemsTheSame(User oldUser, User newUser){

                return oldUser.mUserId.equals(newUser.mUserId);
            }

            @Override
            public boolean areContentsTheSame(User oldUser,
                                              User newUser){

                return oldUser.equals(newUser);
            }
        };
}
