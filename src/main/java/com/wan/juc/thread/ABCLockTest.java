package com.wan.juc.thread;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wanyaming
 * @since 2020年2月13日 下午9:43:26
 */
public class ABCLockTest {
    private Lock lock = new ReentrantLock();
    private String currentThread = "A";

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        ABCLockTest abc = new ABCLockTest();

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        threadPool.submit(abc.new ThreadA());
        threadPool.submit(abc.new ThreadB());
        threadPool.submit(abc.new ThreadC());

        threadPool.shutdown();
    }

    private class ThreadA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (!StringUtils.equals(currentThread, "A")) {
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                currentThread = "B";
                conditionB.signal();
                lock.unlock();
            }
        }
    }

    private class ThreadB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (!StringUtils.equals(currentThread, "B")) {
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                currentThread = "C";
                conditionC.signal();
                lock.unlock();
            }
        }
    }

    private class ThreadC implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (!StringUtils.equals(currentThread, "C")) {
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                currentThread = "A";
                conditionA.signal();
                lock.unlock();
            }
        }
    }
}
