package com.wealth.test.activities;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wealth.test.R;
import com.wealth.test.adapters.UserAdapter;
import com.wealth.test.imp_contracts.UserDetailContract;
import com.wealth.test.models.UserData;
import com.wealth.test.presenters.UserDetailsPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements UserDetailContract.View{

    UserDetailContract.UserActionsListener userActionsListener;
    private List<UserData> userList = new ArrayList<>();
    private UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userActionsListener.callUserDetailsApi();
    }

    @Override
    public void initSetContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initComponents() {
        userActionsListener = new UserDetailsPresenter(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new UserAdapter(userList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void updateUserData(ArrayList<UserData> userDatas) {
        userList.clear();
        userList.addAll(userDatas);
        mAdapter.notifyDataSetChanged();
    }
}
