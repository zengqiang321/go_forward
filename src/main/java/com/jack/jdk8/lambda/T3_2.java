package com.jack.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manchong on 2020/5/23.
 */
public class T3_2 {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("jack",16,89));
        list.add(new Student("manchong",13,90));
        list.add(new Student("zengjack",15,70));
        list.add(new Student("baijack",14,100));

        T3_1.getByFilter(list,student -> student.getAge()>14);
        System.out.println("----------");
        T3_1.getByFilter(list,student -> student.getScore()>75);
        System.out.println("----------");
        T3_1.getByFilter(list,student -> student.getScore()>75&&student.getAge()>14);
    }

}
