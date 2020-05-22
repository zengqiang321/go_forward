package com.jack.rpc.demo4;

import com.jack.rpc.UserService;

/**
 * Created by manchong on 2020/5/18.
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getUser() {
        return "jack";
    }

    @Override
    public String getUserById(String id) {
        return "jack-"+id;
    }
}
