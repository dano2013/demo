package com.example.demo;

public class TestDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonThread());
        //thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wanle");
    }

    static class DaemonThread implements Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("daemon...");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
