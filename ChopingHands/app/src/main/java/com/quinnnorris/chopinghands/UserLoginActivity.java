package com.quinnnorris.chopinghands;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.quinnnorris.chopinghands.presenter.UserLoginPresenter;
import com.quinnnorris.chopinghands.view.ImplUserLoginView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UserLoginActivity extends AppCompatActivity implements ImplUserLoginView {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private Button mBtnRegister;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        getSupportActionBar().hide();

        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);

        mBtnRegister = (Button) findViewById(R.id.id_btn_register);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);

        mUserLoginPresenter.check();

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.register();
            }
        });
    }


    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void toRegisterActivity() {

    }

    @Override
    public void toMainActivity(String username) {
        Intent intent = new Intent(UserLoginActivity.this, HomePageActivity.class);
        intent.putExtra("phone_number", username);
        startActivity(intent);
        saveUserMes(username);
    }

    private void saveUserMes(String phone) {

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = openFileOutput("UserMessage", Context.MODE_PRIVATE);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            bw.write("phone "+phone);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void showFailedError(String error_code) {
        Toast.makeText(this,
                error_code, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String checkLogin() {
        FileInputStream fis = null;
        InputStreamReader isr =null;
        BufferedReader br = null;
        String readLine = null;
        String getLogin = null;

        try{
            fis = openFileInput("UserMessage");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            while((readLine=br.readLine())!=null)
                if(readLine.startsWith("phone "))
                    getLogin = readLine.substring(6);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(br!=null)
                    br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return getLogin;
    }
}
