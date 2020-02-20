package com.example.demo;

import com.example.demo.test.Inter;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    public void threadTest() {
        asyncTaskService.executeAsyncTask(1);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private SjjhDemo sjjhDemo;

    @Test
    public void sjjhTest() {
        sjjhDemo.method1();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void streamTest() {
        List<Student> nums = Arrays.asList(new Student(1,"aa"),

                new Student(1,"bb"),
                new Student(3,"cc"));

//        Map<Integer, Student> map = nums.stream().collect(Collectors.toMap(Student::getId, Function.identity(),(key1, key2) -> key1 ));
//        Map<Integer, List<Student>> map = nums.stream().collect(Collectors.toMap(Student::getId, v -> list(v), (v1, v2) -> v2));
//        Map<Integer, List<Student>> map = nums.parallelStream().collect(Collectors.groupingBy(Student::getId));
        Map<Integer, List<Student>> map = new HashMap<>();
        for (Student s : nums) {
            List<Student> studentList = map.get(s.getId());
            if (studentList == null || studentList.size() == 0) {
                studentList = new ArrayList();
            }
            studentList.add(s);
            map.put(s.getId(), studentList);
        }



        map.forEach((key,value) -> {
            System.out.println(key+";"+value);
        });

    }

    private List<Student> list(Student s) {
        List list = new ArrayList();
        list.add(s);
        return list;
    }


    @Test
public void testList() {
    List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    Random random = new Random();
    for (int i = 0; i < 100; i++) {
        new Thread(() -> {
            list.add(random.nextInt(10));
            System.out.println(list);
        }).start();
    }
}

    @Test
    public void testDaemon() throws InterruptedException {
        Thread dt = new Thread(new DaemonThread(), "dt");
        //dt.setDaemon(true);
        dt.start();
        Thread.sleep(3000);
        System.out.println("完了");
    }

class DaemonThread implements Runnable{
    @Override
    public void run() {
        while (true) {
            process();
        }
    }

    private void process() {
        try {
            System.out.println("daemon");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

    @Autowired
    private Inter inter;

    @Test
    private void test4() {
        inter.test();
    }
}
