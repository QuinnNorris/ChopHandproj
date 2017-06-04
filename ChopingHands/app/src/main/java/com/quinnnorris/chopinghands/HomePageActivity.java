package com.quinnnorris.chopinghands;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {

    private TextView hello ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initViews();
    }

    private void initViews(){
        hello = (TextView) findViewById(R.id.home_hello);
        String phone = getIntent().getStringExtra("phone_number");
        hello.setText("hello "+ phone);
    }
}
