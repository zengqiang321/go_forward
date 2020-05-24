package com.jack.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.8 前迭代方式 ，T3_1,T3_2演变成1.8简单输出
 * Created by manchong on 2020/5/23.
 */
public class T3 {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("jack",16,89));
        list.add(new Student("manchong",13,90));
        list.add(new Student("zengjack",15,70));
        list.add(new Student("baijack",14,100));

        //查找年龄大于14的学生
        findByAge(list);
        System.out.println("---------------");
        //查找分数大于75的学生
        findByScore(list);
    }

    public static void findByAge(List<Student> list) {
        List<Student> students = new ArrayList<>();
        for (Student student : list) {
            if(student.getAge()>14) {
                students.add(student);
            }
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void findByScore(List<Student> list) {
        List<Student> students = new ArrayList<>();
        for (Student student : list) {
            if(student.getScore()>75) {
                students.add(student);
            }
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

}
class Student {
    private String name;
    private int age;
    private int score;

    public Student(String name,int age,int score) {
        this.name=name;
        this.age=age;
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
