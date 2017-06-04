package com.quinnnorris.chopinghands.service;

/**
 * Created by QuinnNorris on 2017/5/22.
 */

public interface UserLoginOnLoginListener {

    void loginSuccess(String username, String password);

    void loginFailed(String error_code);

}
