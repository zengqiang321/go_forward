package com.jack.equal;

/**
 * Created by manchong on 2019/7/12.
 */
public class T1 {

    public static void main(String[] args) {
        //比较的是两个变量内存地址是否一值
        Integer a=1024;
        Integer c=1024;
        System.out.println(a==c);

        //-128~127    比较的是基础数据类型，比较的是值
        a=127;
        c=127;
        System.out.println(a==c);


        Integer d=1;
        Byte e=1;
        System.out.println(d.equals(e));

        T1 t=new T1();

        T1 t2 = new T1();
        System.out.println(t.equals(t2));

        String s1 = new String("111");
        String s2 = new String("111");
        System.out.println(s1.equals(s2));
    }

}
