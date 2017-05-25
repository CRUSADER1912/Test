package com.wealth.test.presenters;

import com.wealth.test.imp_contracts.UserDetailContract;
import com.wealth.test.models.UserData;
import com.wealth.test.networking.NetworkRequestHandler;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by linus on 25/5/17.
 */

public class UserDetailsPresenter implements UserDetailContract.UserActionsListener{

    UserDetailContract.View view;

    public UserDetailsPresenter(UserDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void callUserDetailsApi() {

        new NetworkRequestHandler(new NetworkRequestHandler.RetrofitResponseListener() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()) {
                    ArrayList<UserData> userDatas = (ArrayList<UserData>) response.body();
                    if(userDatas != null){
                        view.updateUserData(userDatas);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        }).getUserDetails();

    }
}
