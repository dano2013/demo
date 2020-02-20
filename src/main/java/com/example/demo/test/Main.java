package com.example.demo.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 批量数据 -> Stream对象
        Stream stream1 = Stream.of("1", "2", "3");
        String s = stream1.collect(Collectors.joining()).toString();

        Object[] array = new Object[]{};
        Stream stream2 = Arrays.stream(array);

        List<String> list = new ArrayList<>();
        Stream stream3 = list.stream();
        List<String> list1 = (List<String>) stream3.collect(Collectors.toList());

        HashSet<Object> set = new HashSet<>();
        Stream stream4 = set.stream();
        Set<String> set1 = (Set<String>) stream4.collect(Collectors.toSet());

        Map<String, Integer> map = new HashMap<>();
        Stream stream5 = map.entrySet().stream();
        Map<String, String> map1 = (Map<String, String>) stream5.collect(Collectors.toMap(x -> x, y -> y));

        //Stream中常见的API操作
        //给list中的值增加一个前缀
        list = list.stream().map(x -> "+++:" + x).collect(Collectors.toList());
        list.forEach(System.out::println);

        //添加过滤条件
        list = list.stream().filter(x -> x.length() > 5).collect(Collectors.toList());

        //peek()中间操作，迭代数据完成数据的依次处理过程
        list.stream()
                .peek(x -> System.out.println("peek1" + x))
                .peek(x -> System.out.println("peek2" + 2))
                .forEach(System.out::println);


    }
}
