package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
    @Autowired
    private AsyncTaskService2 asyncTaskService2;
//    @Async
    public void executeAsyncTask(int i) {
        for (int i1 = 0; i1 < 5; i1++) {
            System.out.println("正在跑"+i1);
            asyncTaskService2.executeAsyncTask2(33);
            /*try {
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("跑完啦");
    }


}
