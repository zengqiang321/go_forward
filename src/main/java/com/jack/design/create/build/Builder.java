package com.jack.design.create.build;

/**
 * Created by manchong on 2020/4/7.
 */
public interface Builder {

    void setCarWheel(String wheel);

    void setCarHead(String head);

    Car build();

}
