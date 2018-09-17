package com.yumingchuan.testdemo.thread;

import com.yumingchuan.testdemo.utils.LogUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yumingchuan on 2018/9/17.
 * java.util.concurrent.lock 中的 Lock 框架是锁定的一个抽象，
 * 通过对lock的lock()方法和unlock()方法实现了对锁的显示控制，而synchronize()则是对锁的隐性控制。
 * 可重入锁，也叫做递归锁，指的是同一线程 外层函数获得锁之后 ，
 * 内层递归函数仍然有获取该锁的代码，但不受影响，简单来说，该锁维护这一个与获取锁
 * 相关的计数器，如果拥有锁的某个线程再次得到锁，那么获取计数器就加1，函数调用结束计数器就减1，
 * 然后锁需要被释放两次才能获得真正释放。已经获取锁的线程进入其他需要相同锁的同步代码块不会被阻塞
 */

public class ProducerCosumerRLock {
    private int MAX = 10;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void main() {
        ProducerCosumerRLock producerCosumerRLock = new ProducerCosumerRLock();
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
                lock.lock();
                try {
                    while (count == MAX) {
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    LogUtils.i("生产者生产，一共生产了", count + "个产品");
                    notEmpty.signal();
                } finally {
                    lock.unlock();
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

                lock.lock();
                try {

                    while (count == 0) {
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    LogUtils.i("消费者消费，剩余", count + "个产品");
                    notFull.signal();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

}
