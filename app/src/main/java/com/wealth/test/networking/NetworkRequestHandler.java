package com.wealth.test.networking;

import com.wealth.test.models.UserData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by linus on 18/2/16.
 */
public class NetworkRequestHandler {

    RetrofitResponseListener listener;
    private RetrofitClient.RetroApiInterface retroApiInterface;

    public NetworkRequestHandler(RetrofitResponseListener listener) {
        retroApiInterface = RetrofitClient.getClient();
        this.listener = listener;
    }

    public NetworkRequestHandler getUserDetails() {

        Call<ArrayList<UserData>> callSBIProfileList = retroApiInterface.loadUserDetails();


        callSBIProfileList.enqueue(new Callback<ArrayList<UserData>>() {
            @Override
            public void onResponse(Call<ArrayList<UserData>> call, Response<ArrayList<UserData>> response) {
                listener.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<ArrayList<UserData>> call, Throwable t) {
                listener.onFailure(call, t);
            }
        });
        return this;
    }

    public interface RetrofitResponseListener<T> {
        void onResponse(Call<T> call, Response<T> response);

        void onFailure(Call<T> call, Throwable t);
    }
}
