package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
public class SjjhDemo {

    @Autowired
    private AsyncTaskService2 asyncTaskService2;


    public void method1(){
        int a = 0;

        while (true){
            a++;

            if (a < 150) {
                System.out.println("method1 ：" + a);
                if (!asyncTaskService2.isFlag()) {
                    asyncTaskService2.setFlag(true);
                    System.out.println("开始调用method2");
                    asyncTaskService2.method2();
                }
            } else {
                asyncTaskService2.setFlag(false);
                System.out.println("状态改成false");
                break;
            }
        }
    }



}
