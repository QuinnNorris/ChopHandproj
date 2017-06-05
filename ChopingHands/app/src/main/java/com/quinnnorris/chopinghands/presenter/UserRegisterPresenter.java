package com.quinnnorris.chopinghands.presenter;

import android.os.Handler;

import com.quinnnorris.chopinghands.service.Register.ImplRegisterService;
import com.quinnnorris.chopinghands.service.Register.RegisterService;
import com.quinnnorris.chopinghands.view.ImplRegisterView;

/**
 * Created by QuinnNorris on 2017/6/4.
 */

public class UserRegisterPresenter {

    private ImplRegisterService registerService;
    private ImplRegisterView registerView;
    private Handler mHandler = new Handler();

    public UserRegisterPresenter(ImplRegisterView registerView) {
        this.registerView = registerView;
        this.registerService = new RegisterService();
    }

    public void sendText(String phone){
        registerView.sendText(phone);
    }


}
