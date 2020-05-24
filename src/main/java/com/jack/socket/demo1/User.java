package com.jack.socket.demo1;

import java.io.Serializable;

/**
 * Created by manchong on 2020/5/23.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8968621324160421416L;

    private String username;
    private String password;

    public User(String username,String password) {
        this.username=username;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
