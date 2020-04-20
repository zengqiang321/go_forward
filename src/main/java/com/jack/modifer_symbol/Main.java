package com.jack.modifer_symbol;

import com.jack.modifer_symbol.symbol.SymbolClass;

/**
 * Created by manchong on 2020/3/26.
 */
public class Main extends SymbolClass {

    public void test() {
        this.protectedTest2();
        this.protectedField="100";

        //不同包中 子类 可以访问到public,protected的成员变量\方法.   但是不能访问private,default 属性和方法
        //接口、类 只允许default,public 修饰。
        //内部类 才可以允许default,protected,private,public 修饰
        //子类不能继承被default,protected,private修饰的类,除非在同一个类中




    }


}
