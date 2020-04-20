package com.jack.modifer_symbol.symbol;

/**
 * Created by manchong on 2020/3/26.
 */
public class SamePackageClass extends SymbolClass{


//    class InnerSamePackageClass extends PrivateSym



    static {
        x=100;
    }

    public static  int x=0;

    public void test() {

//        System.out.println();
//        //跟着SymbolClass一起被继承过来了，没有被继承只能用下面方式实例化
//        DefaultSymbolClass d=new DefaultSymbolClass();
//
//        SymbolClass symbolClass = new SymbolClass();
//        //成员内部类
//        SymbolClass.DefaultSymbolClass defaultSymbolClass = symbolClass.new SymbolClass.DefaultSymbolClass();
//
//        SymbolClass.ProtectedSymbolClass protectedSymbolClass = symbolClass.new SymbolClass.ProtectedSymbolClass();
//
//        SymbolClass.T t = symbolClass.new SymbolClass.T();

    }



}
