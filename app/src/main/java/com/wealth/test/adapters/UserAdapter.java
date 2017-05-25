package com.wealth.test.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.test.R;
import com.wealth.test.models.UserData;

import java.util.List;
 
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
 
    private List<UserData> userList;
 
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView user_name, user_phone;
 
        public MyViewHolder(View view) {
            super(view);
            user_name = (TextView) view.findViewById(R.id.user_name);
            user_phone = (TextView) view.findViewById(R.id.user_phone);
        }
    }
 
 
    public UserAdapter(List<UserData> userList) {
        this.userList = userList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UserData userData = userList.get(position);
        holder.user_name.setText(userData.getName());
        holder.user_phone.setText(userData.getMobileNumber());
    }
 
    @Override
    public int getItemCount() {
        return userList.size();
    }
}