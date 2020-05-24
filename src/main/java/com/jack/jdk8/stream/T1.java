package com.jack.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 引入函数式编程，原因：
 *      1.代码简洁，函数式编程 写出来的代码简洁且意图明确，使用Stream接口让你从此告别for循环
 *      2.多核友好，Java函数式编程使得编写并行程序特别简单，你需要的全部就是调用一下parallel()方法
 *  特性:
 *      1.不是数据结构，没有内部结构
 *      2.不支持索引访问
 *      3.延迟计算
 *      4.支持并行计算
 *      5.很容易生成数组或者集合(List,Set)
 *      6.支持过滤，查找，转换，汇总，聚合等操作
 *
 *   T1.   Stream 创建的5中方式
 * Created by manchong on 2020/5/24.
 */
public class T1 {


    public static void main(String[] args) {

        //1.通过数组生成Stream
        String[] strs={"a","b","c","d"};
        Stream<String> stream = Stream.of(strs);
        stream.forEach(System.out::println);

        //2.通过集合生成Stream;
        List<String> list = Arrays.asList("a","b","c","d");
        list.stream().forEach(System.out::println);

        //3.通过Stream.generator生成
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);

        //4.通过iterate生成自增序列
        System.out.println("-=-=0=0==");
        Stream stream1=Stream.iterate(1,(x)->x+1);
        stream1.limit(10).forEach(System.out::println);

        System.out.println("-=-=-=-=");
        //5.
        String str="abcdefg";
        str.chars().forEach(System.out::println);


    }


}
