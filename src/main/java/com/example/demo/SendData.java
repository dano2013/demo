package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendData {

    @Async
    public void sendData(int b) {
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送数据："+b +":"+ System.currentTimeMillis()+":"+Thread.currentThread().getName());
    }
}
