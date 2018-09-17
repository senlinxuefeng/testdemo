package com.yumingchuan.testdemo.thread;

import com.yumingchuan.testdemo.utils.LogUtils;

/**
 * Created by yumingchuan on 2018/9/17.
 * 这也是最简单最基础的实现，缓冲区满和为空时都
 * 调用wait()方法等待，当生产者生产了一个产品或者消费者消费了一个产品之后会唤醒所有线程。
 */

public class ProducerCosumerSynch {
    private int MAX = 10;
    private int count = 0;
    private Object lock = new Object();


    public void main() {
        ProducerCosumerSynch producerCosumerRLock = new ProducerCosumerSynch();
        new Thread(producerCosumerRLock.new Producer()).start();
        new Thread(producerCosumerRLock.new Producer()).start();
        new Thread(producerCosumerRLock.new Producer()).start();

        new Thread(producerCosumerRLock.new Consumer()).start();
        new Thread(producerCosumerRLock.new Consumer()).start();
    }

    private class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == MAX) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    LogUtils.i("生产者生产，一共生产了", count + "个产品");
                    lock.notifyAll();
                }
            }
        }
    }

    private class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock) {
                    while (count == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    LogUtils.i("消费者消费，剩余", count + "个产品");
                    lock.notifyAll();
                }
            }
        }
    }

}
