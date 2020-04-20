package com.jack.changeIntegerValue;

import java.lang.reflect.Field;

/**
 * Created by manchong on 2019/8/6.
 */
public class T {

    public static void changeIntValue(Integer a) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);

//            Field modifiersField = Field.class.getDeclaredField("modifiers");
//            modifiersField.setAccessible(true);
//            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(a,new Integer(1299));
            System.out.println(a);
//            return a;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        Integer a = 1;
        changeIntValue(a);
        System.out.println(a);

        String s="123";
        System.out.println(s.indexOf("123"));

        int sshift = 0;
        int ssize = 1;
        while (ssize < 65536) {
            ++sshift;
            ssize <<= 1;
        }
        System.out.println(sshift);
        System.out.println(ssize);
//        for (int i=65535;i<65835;i++) {
//            System.out.println(i & 65535);
//        }

        int EXCLUSIVE_MASK = (1 << 16) - 1;
        System.out.println(EXCLUSIVE_MASK);


        System.out.println(142 & 129);
    }

}
