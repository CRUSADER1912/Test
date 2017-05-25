package com.wealth.test.imp_contracts;

import com.wealth.test.models.UserData;

import java.util.ArrayList;

/**
 * Created by linus on 25/5/17.
 */

public interface UserDetailContract {

    interface View {
        void updateUserData(ArrayList<UserData> userDatas);
    }

    interface UserActionsListener {

        void callUserDetailsApi();

    }

}
