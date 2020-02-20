package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsyncTaskService2 {
    private static volatile boolean flag;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public AsyncTaskService2() {
    }

    public AsyncTaskService2(boolean flag) {
        this.flag = flag;
    }

    @Autowired
    SendData sendData;

    @Async
    public void method2() {
        int b = 100;

        while (true) {
            b--;

            if (b>0) {
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("发送数据 :" + b);
                */
                try {
                    sendData.sendData(b);
                } catch (TaskRejectedException e) {
                    e.printStackTrace();
                }
            } else {
                flag = false;
                System.out.println("发完了" + Thread.currentThread().getName());
                break;
            }
        }
    }

    @Async
//    @Transactional(timeout = 1)
    public void executeAsyncTask2(int i) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + " 执行异步任务：" + System.currentTimeMillis());
    }
}
