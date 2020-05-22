package com.jack.spring_code_src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by manchong on 2020/5/12.
 */
@Service("goodsService")
public class GoodService {
     @Autowired
     @Qualifier("userService")
     private UserService userService;

    public String getGoods(){
        return "";
    }
}
