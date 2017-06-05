package com.quinnnorris.chopinghands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.quinnnorris.chopinghands.presenter.UserRegisterPresenter;
import com.quinnnorris.chopinghands.view.ImplRegisterView;

public class RegisterActivity extends AppCompatActivity implements ImplRegisterView{

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnSend;
    private Button mBtnRegister;

    private UserRegisterPresenter userRegisterPresenter = new UserRegisterPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.re_phone);
        mEtPassword = (EditText) findViewById(R.id.re_password);

        mBtnRegister = (Button) findViewById(R.id.re_register);
        mBtnSend = (Button) findViewById(R.id.re_send);

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegisterPresenter.sendText(mEtUsername.getText().toString());
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void sendText(String phone){

    }

    @Override
    public void registerUser() {

    }
}
