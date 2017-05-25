package com.wealth.test.activities;

import android.os.Bundle;

import com.wealth.test.R;
import com.wealth.test.networking.NetworkRequestHandler;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new NetworkRequestHandler(new NetworkRequestHandler.RetrofitResponseListener() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        }).getUserDetails();


    }

    @Override
    public void initSetContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initComponents() {

    }

    @Override
    public void initListeners() {

    }
}
