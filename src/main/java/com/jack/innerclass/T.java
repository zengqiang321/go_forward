package com.jack.innerclass;

/**
 * Created by manchong on 2020/4/6.
 */
public class T {

    static {
        System.out.println("我的T类");
    }

    public static void main(String[] args) {
        T t = new T();

        T2 t2=t.new T2();

        T1 t1 = new T1();
        t.t1=t1;
        System.out.println(t.t1.a+"==="+t.t1.b);
    }

    private T1 t1;

    public static class T1{
        public int a=1;
        public static int b=2;
        static {
            System.out.println("我是静态内部类");
            b=3;
        }

    }


    class T2 {
//        static {}
      public T2() {
            System.out.println("我是成员内部类");
        }
    }

}
