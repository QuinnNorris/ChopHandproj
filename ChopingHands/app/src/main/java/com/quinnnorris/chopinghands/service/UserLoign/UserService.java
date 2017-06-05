package com.quinnnorris.chopinghands.service.UserLoign;

import com.quinnnorris.chopinghands.configure.ErrorCodes;
import com.quinnnorris.chopinghands.dao.User;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by QuinnNorris on 2017/5/22.
 */

public class UserService implements ImplUserService {

    @Override
    public void login(final String username, final String password, final UserLoginOnLoginListener loginListener) {

        new Thread() {
            @Override
            public void run() {

                List<User> users = DataSupport
                        .select("phoneNumber")
                        .where("phoneNumber = ? and passWord = ?", username, password)
                        .find(User.class);

                if (!users.isEmpty())
                    loginListener.loginSuccess(username, password);
                else {
                    List<User> error_users = DataSupport
                            .select("phoneNumber")
                            .where("phoneNumber = ? ", username)
                            .find(User.class);
                    if (error_users.isEmpty())
                        loginListener.loginFailed(ErrorCodes.CODE_2);
                    else
                        loginListener.loginFailed(ErrorCodes.CODE_3);

                }
                /*
                if ("qnz".equals(username) && "123".equals(password)) {
                    loginListener.loginSuccess(username,password);
                } else {
                    loginListener.loginFailed();
                }
                */
            }
        }.start();
    }

    @Override
    public void check(final UserLoginCheckListener checkListener, final UserLoginOnLoginListener loginOnLoginListener) {

        new Thread() {
            @Override
            public void run() {

                String localPhone = checkListener.getLocalPhone();
                if (localPhone != null) {
                    List<User> users = DataSupport
                            .select("phoneNumber")
                            .where("phoneNumber = ?", localPhone)
                            .find(User.class);
                    if (!users.isEmpty()) {
                        loginOnLoginListener.loginSuccess(checkListener.getLocalPhone(), "");
                        return;
                    }
                }
                loginOnLoginListener.loginFailed(ErrorCodes.CODE_4);

            }
        }.start();
    }
}
