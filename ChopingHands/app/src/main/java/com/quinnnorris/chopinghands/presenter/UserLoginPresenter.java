package com.quinnnorris.chopinghands.presenter;

import android.os.Handler;

import com.quinnnorris.chopinghands.service.ImplUserService;
import com.quinnnorris.chopinghands.service.UserLoginCheckListener;
import com.quinnnorris.chopinghands.service.UserLoginOnLoginListener;
import com.quinnnorris.chopinghands.service.UserService;
import com.quinnnorris.chopinghands.view.ImplUserLoginView;

/**
 * Created by QuinnNorris on 2017/5/22.
 */

public class UserLoginPresenter {

    private ImplUserService userService;
    private ImplUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(ImplUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userService = new UserService();
    }

    public void login() {
        userService.login(userLoginView.getUserName(), userLoginView.getPassword(), new ExLogin());
    }

    public void register() {
        userLoginView.toRegisterActivity();
    }

    public void check() {
        userService.check(new UserLoginCheckListener() {

            @Override
            public String getLocalPhone() {
                return userLoginView.checkLogin();
            }

        }, new ExLogin());

    }

    class ExLogin implements UserLoginOnLoginListener{
        @Override
        public void loginSuccess(final String username, final String password) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    userLoginView.toMainActivity(username);
                }
            });
        }

        @Override
        public void loginFailed(final String error_code) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    userLoginView.showFailedError(error_code);
                }
            });

        }
    }

}
