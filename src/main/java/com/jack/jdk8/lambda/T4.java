package com.jack.jdk8.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 函数式接口
 * Supplier 代表一个输出
 * Consumer 代表一个输入
 * BIConsumer 代表两个输入
 *
 * Function 代表一个输入，一个输出. （一般输入和输出是不同类型）
 * UnaryOperator 代表一个输入，一个输出，（输入和输出是相同类型）
 *
 * BIFunction 代表两个输入，一个输出 （一般输入和输出是不同类型）
 * BinaryOperator 代表两个输入，一个输出(输入和输出是相同类型)
 *
 * Created by manchong on 2020/5/23.
 */
public class T4 {

    public static void main(String[] args) {
        StudentDao sd1=new StudentDao() {
            @Override
            public boolean insert(Student student) {
                System.out.println("insert student:"+student);
                return false;
            }
        };
        System.out.println(sd1.insert(new Student("jack", 11, 90)));


        StudentDao sd2=(student)-> {System.out.println("insert student: "+student);return true;};
        System.out.println(sd2.insert(new Student("jack2", 12, 92)));


        TeacherdDao t1 = (i)->new Teacher(i,"Pear"+i);
        System.out.println(t1.get(1));
        System.out.println(t1.get(2));
        System.out.println(t1.get(3));


        //输入一个字符的长度。代表一个输入，一个输出. （一般输入和输出是不同类型）
        Function<String,Integer> function = (param)->{return param.length();};
        System.out.println(function.apply("abcdddd"));

        //一个输出
        Supplier<String> s1=()->"abcd";
        System.out.println(s1.get());

        //两个输入，一个输出
        BiFunction<String,String,Integer> biFunction =(param1,param2)->(param1+param2).length();
        System.out.println("返回两个入参的长度:"+biFunction.apply("param1", "param2"));

        Consumer<String> c=(param)-> System.out.println("输入的参数:"+param);
        c.accept("我是入参数");
    }

}

class Teacher{
    private String name;
    private int id;

    public Teacher(int id,String name) {
        this.id=id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id="+id+","+
                "name='" + name + '\'' +
                '}';
    }
}

@FunctionalInterface
interface StudentDao{
    boolean insert(Student student);
}

@FunctionalInterface
interface TeacherdDao{
    Teacher get(int id);
}
