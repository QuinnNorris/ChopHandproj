package com.quinnnorris.chopinghands.dao;

import org.litepal.crud.DataSupport;

/**
 * Created by QuinnNorris on 2017/5/23.
 */

public class User extends DataSupport {

    private int id;

    private String userName;

    private String passWord;

    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
