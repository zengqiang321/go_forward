package com.jack.jdkproxy;

/**
 * Created by manchong on 2020/4/5.
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String user, String password) {
        System.out.println("login");
        return false;
    }

}
