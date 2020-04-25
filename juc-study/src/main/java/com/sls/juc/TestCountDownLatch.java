package com.sls.juc;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    private final static  CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5 ; i++) {
            new Thread(new CountDownLatchDemo(countDownLatch)).start();
        }
        countDownLatch.await();
        // 主线程在等待所有的子线程都执行完毕的时候 才会执行主线程
        System.out.println("耗时："+(System.currentTimeMillis() - start));
    }
}

class CountDownLatchDemo implements Runnable {

    private CountDownLatch countDownLatch;
    public CountDownLatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        for (int i = 0; i <50000 ; i++) {
            if( i%2 == 0){
                System.out.println(i);
            }
        }
        countDownLatch.countDown();  //倒计数
    }
}