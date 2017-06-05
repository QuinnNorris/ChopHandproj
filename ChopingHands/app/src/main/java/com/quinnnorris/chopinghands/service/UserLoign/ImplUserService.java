package com.quinnnorris.chopinghands.service.UserLoign;

/**
 * Created by QuinnNorris on 2017/5/22.
 */

public interface ImplUserService {

    public void login(String username, String password, UserLoginOnLoginListener loginListener);

    public void check(UserLoginCheckListener checkListener, UserLoginOnLoginListener loginOnLoginListener);
}
