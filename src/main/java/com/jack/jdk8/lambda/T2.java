package com.jack.jdk8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by manchong on 2020/5/23.
 */
public class T2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java","python","scala","javascript");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        for (String s:list) {
            System.out.println(s);
        }

        System.out.println("---------------");

        Collections.sort(list,(o1,o2)->o1.length()-o2.length());
        list.forEach(System.out::println);
    }

}
