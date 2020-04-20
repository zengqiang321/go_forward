package com.jack.exception;

/**
 * Created by manchong on 2020/4/6.
 */
public class T {

    public static void main(String[] args) {
        try {
            System.out.println(a());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static int a(){
        try {
//            System.out.println(readme/0);
        return 100;
        } catch (Exception e){
//            e.printStackTrace();
            System.out.println("我是异常");
            throw e;
        } finally {
            System.out.println("ddsfdsdf");   // 特别注意。当finally 中有return语句的时候，会将异常栈给清空，外面捕获不到这个异常
            //会改变返回值
            return 1;
        }
    }

}
