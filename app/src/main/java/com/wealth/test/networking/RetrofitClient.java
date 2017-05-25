package com.wealth.test.networking;

import com.wealth.test.AppConstants;
import com.wealth.test.models.UserData;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitClient {

    private static final String TAG = "Retrofit";
    public static RetroApiInterface retroApiInterface;
    private final static String USER_DETAIL_URL = "/users";

    public static RetroApiInterface getClient() {
        if (retroApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient.Builder()
                    .build();
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            retroApiInterface = client.create(RetroApiInterface.class);
        }
        return retroApiInterface;
    }

    public interface RetroApiInterface {

        @GET(USER_DETAIL_URL)
        Call<ArrayList<UserData>> loadUserDetails();

    }

}
