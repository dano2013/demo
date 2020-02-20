package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(new Student(i%100,i+""));
        }

        //list转map


        //普通for
        long l1 = System.currentTimeMillis();
        Map<Integer,List<Student>> map1 = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            List<Student> students = map1.get(s.getId());
            if (students == null) {
                students = new ArrayList<>();
            }
            students.add(s);
            map1.put(s.getId(), students);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1+"-----------"+map1.size());
        //增强for
        Map<Integer,List<Student>> map2 = new HashMap<>();
        for (Student s : list) {
            List<Student> students = map2.get(s.getId());
            if (students == null) {
                students = new ArrayList<>();
            }
            students.add(s);
            map2.put(s.getId(), students);
        }
        long l3 = System.currentTimeMillis();
        System.out.println(l3-l2+"-----------"+map1.size());

        //iterator
        Map<Integer,List<Student>> map3 = new HashMap<>();
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            List<Student> students = map3.get(student.getId());
            if (students == null) {
                students = new ArrayList<>();
            }
            students.add(student);
            map3.put(student.getId(), students);
        }
        long l4 = System.currentTimeMillis();
        System.out.println(l4-l3+"-----------"+map1.size());

        //stream
        Map<Integer, List<Student>> map4 = list.stream().collect(Collectors.groupingBy(Student::getId));
        long l5 = System.currentTimeMillis();
        System.out.println(l5-l4+"-----------"+map1.size());

        //parallelStream
        Map<Integer, List<Student>> map5 = list.parallelStream().collect(Collectors.groupingBy(Student::getId));
        long l6 = System.currentTimeMillis();
        System.out.println(l6-l5+"-----------"+map1.size());

    }
}
