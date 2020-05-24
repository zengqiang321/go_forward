package com.jack.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by manchong on 2020/5/24.
 */
public class T2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 7, 4, 6,0,3,8,4,6);
        //取偶数
        list.stream().filter((x)->x%2==0).forEach(System.out::println);

        //新集合长度
        long count=list.stream().filter((x)->{return x%2==0;}).count();
        System.out.println("求符合条件的数量："+count);

        //求和
        long sum=list.stream().filter((x)->x%2==0).mapToInt((x)->x).sum();
        System.out.println("求和:"+sum);

        //求最大
        Integer max=list.stream().filter((x)->x%2==0).max((x,y)-> x-y).get();
        System.out.println("求最大值："+max);

        // 观察Stream运行原理。只要在终止命令时才会运行filter这样的函数
        // 数字1--执行--->filter----不满足
        //数字2--执行--->filter----执行---->findAny 满足     这里用foreach更能看出逻辑
        //数字3，4，5
        Stream stream= list.stream().filter((x -> {
            System.out.println("x:" + x);
            return x % 2 == 0;
        }));
        System.out.println("-=-=-=-=-=");
        Optional<Integer> optional =stream.findAny();
        System.out.println(optional.get());


        //不实用min和max来得到最大，最小值
        //1.需要自己先排序
        //2.取最小值
        Optional<Integer> optional1 = list.stream().sorted((x, y) -> x - y).findFirst();
        System.out.println(optional1.get());

        optional1 = list.stream().sorted().findFirst();
        System.out.println(optional1.get());

        //取最大值
        optional1 = list.stream().sorted((x, y) -> y-x).findFirst();
        System.out.println(optional1.get());

        System.out.println("-=-=-=-=-=-==-");
        list.stream().sorted((x, y) -> y-x).forEach(System.out::println);


        System.out.println("===============");
        //将结果存到新集合
        List<Integer> collect = list.stream().filter((x) -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("==========");
        //去重
        list.stream().distinct().forEach(System.out::println);
        System.out.println("==========");
        list.stream().collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("==========");
        //打印20-50这样的集合数据
        Stream.iterate(1,(x)->x+1).limit(50).skip(20).limit(10).forEach(System.out::println);

        //求和
        String str="1,2,3,4,5,6,7,8";
        int sum1 = Stream.of(str.split(",")).mapToInt(x -> Integer.parseInt(x)).sum();
        System.out.println("求和 :"+sum1);
        sum1= Stream.of(str.split(",")).map(x->Integer.parseInt(x)).mapToInt(x->x).sum();
        System.out.println("求和 :"+sum1);
        sum1 = Stream.of(str.split(",")).mapToInt(Integer::parseInt).sum();
        System.out.println("求和 :"+sum1);

        //将str中的每一个数字都打印出来，同时计算出求和
        sum1=Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::parseInt).sum();
        System.out.println("求和:"+sum1);

        //map使用
        String names="zengqiang,jack,manchong";
        Stream.of(names.split(",")).map((name)->new Person(name)).forEach(System.out::println);
        Stream.of(names.split(",")).map(Person::new).forEach(System.out::println);
        Stream.of(names.split(",")).map(name->Person.build(name)).forEach(System.out::println);
        Stream.of(names.split(",")).map(Person::build).forEach(System.out::println);
    }
}

class Person{
    private String name;
    public Person(String name){
        this.name=name;
    }

    public static Person build(String name) {
        return new Person(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
