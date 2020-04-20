package com.jack.stringintern;

/**
 * Created by manchong on 2020/3/31.
 */
public class T {

    public static void main(String[] args) {
//        String a = new String("AB");
//        String b = "AB";
//        System.out.println(a==a.intern());
//
//        System.out.println(a==b);
//        System.out.println(b.intern()==b);
//
//        System.out.println(a.intern()==b);


//        String a1 = "AABB";
//        String a2 = "AA" + new String("BB");
//        System.out.println(a1 == a2.intern());//true
//        System.out.println(a2 == a2.intern()); //false

//        String a3 = new String("AA");    //在堆上创建对象AA
//        a3.intern(); //在常量池上创建对象AA的引用
//        String a4 = "AA"; //常量池上存在引用AA，直接返回该引用指向的堆空间对象，即a3
//        System.out.println(a3 == a4); //false,如果这个例子不理解，请看完整篇文章再回来看这里

//        //常量池上存在引用AABB
//        String a4 = new String("AA") + new String("BB"); //在堆上创建对象AA、BB和AABB，在常量池上创建常量AA和BB
//        System.out.println(a4==a4.intern());
//        a4.intern();
//        String a5 = "AA" + "BB";
//        System.out.println(a4 == a5); //true



//        String a4 = new String("AA") + new String("BB"); //在堆上创建对象AA、BB和AABB，
//        a4.intern();//在常量池上拷贝a4的引用。
//        System.out.println(a4==a4.intern());//true ，a4的引用地址与a4在常量池中的引用地址一致
//        String a5 = new String("AA") + new String("BB");
//        System.out.println(a4==a5);//false
//        System.out.println(a4==a5.intern());//true
//        //下面这两句证明了a4没有直接在常量池中拷贝a4的引用地址。
//        String a6="AABB";
//        System.out.println(a4==a6); //false
//        //调用a4.intern()后拷贝得到a4的引用地址
//        System.out.println(a4.intern()==a6);//ture
//        //说明a4.intern在常量池的地址是a6在常量池中地址。
//        System.out.println(a4==a4.intern());//false
//        String a7="AABB";
//        System.out.println(a7==a6);



//        String a1="a"+"a"; //在编译器会被优化为"aa"字符串，在常量池中分配内存

//        String a2="a" + new String("a"); //在堆内存中创建a对象，在常量池中分配"aa"
//        System.out.println(a1==a2);//false
//        System.out.println(a2.intern()==a1);


//        String str1 = new StringBuilder("java").toString();
//        System.out.println(str1.intern()==str1);//false
//        String str2 = new String("java");
//        System.out.println(str1.intern()==str2.intern());//true
//        System.out.println(str1==str2);//false
//        System.out.println(str1==str2.intern());
//        String str3="java";
//        System.out.println(str1==str3);//false
//        System.out.println(str1.intern()==str3);//true



    }

}
