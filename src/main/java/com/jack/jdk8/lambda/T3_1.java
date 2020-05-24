package com.jack.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过策略模式，扩展性变好
 * Created by manchong on 2020/5/23.
 */
public class T3_1 {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("jack",16,89));
        list.add(new Student("manchong",13,90));
        list.add(new Student("zengjack",15,70));
        list.add(new Student("baijack",14,100));

        getByFilter(list,new AgeFilter());
        System.out.println("---------");
        getByFilter(list,new ScoreFilter());

        //需求变更，增加年龄>14分数大于75
        System.out.println("---------");
        getByFilter(list,new AgeAndScoreFilter());

    }

    public static void getByFilter(List<Student> list,StudentInterface filter) {
        List<Student> students = new ArrayList<>();
        for (Student student : list) {
            if(filter.compare(student)){
                students.add(student);
            }
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

}

interface StudentInterface {
    boolean compare(Student student);
}

class AgeFilter implements StudentInterface {
    @Override
    public boolean compare(Student student) {
        return student.getAge()>14;
    }
}

class ScoreFilter implements StudentInterface {
    @Override
    public boolean compare(Student student) {
        return student.getScore()>75;
    }
}


class AgeAndScoreFilter implements StudentInterface {
    @Override
    public boolean compare(Student student) {
        return student.getScore()>75 && student.getAge()>14;
    }
}
