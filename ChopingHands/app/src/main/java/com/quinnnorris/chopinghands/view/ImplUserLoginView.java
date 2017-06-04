package com.quinnnorris.chopinghands.view;

/**
 * Created by QuinnNorris on 2017/5/22.
 */

public interface ImplUserLoginView {

    String checkLogin();

    String getUserName();

    String getPassword();

    void toRegisterActivity();

    void toMainActivity(String username);

    void showFailedError(String error_code);

}
