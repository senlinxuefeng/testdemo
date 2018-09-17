package com.yumingchuan.testdemo.thread;

import com.yumingchuan.testdemo.utils.LogUtils;

import java.util.concurrent.LinkedBlockingDeque;


/**
 * Created by yumingchuan on 2018/9/17.
 * 使用BlockingQueue实现生产者消费者模型
 */

public class ProducerCosumerBlockQuene {
    private int MAX = 10;
    private int count = 0;
    LinkedBlockingDeque blockingDeque = new LinkedBlockingDeque<>(MAX);

    public void main() {
        ProducerCosumerBlockQuene producerCosumerRLock = new ProducerCosumerBlockQuene();
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

                try {
                    blockingDeque.push(1);
                    count++;
                    LogUtils.i("生产者生产，一共生产了", count + "个产品");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

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
                try {
                    blockingDeque.take();
                    count--;
                    LogUtils.i("消费者消费，剩余", count + "个产品");

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }

            }
        }
    }

}
