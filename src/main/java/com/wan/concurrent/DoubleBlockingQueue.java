package com.wan.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DoubleBlockingQueue {
    private ArrayBlockingQueue<Map<String, String>> firstQueue;

    private LinkedBlockingDeque<Map<String, String>> secondQueue;

    private Condition notEmpty;
    private ReentrantLock lock;

    public DoubleBlockingQueue(int capacity) {
        this.firstQueue = new ArrayBlockingQueue(capacity);
        this.secondQueue = new LinkedBlockingDeque();
        lock = new ReentrantLock(false);

        notEmpty = lock.newCondition();
    }

    /**
     * 非阻塞插入元素
     * @param e
     */
    public boolean offer(Map<String, String> e) {
        boolean result = false;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (firstQueue.offer(e)) {
                result = true;
            } else {
                e.put("async", "true");
                secondQueue.offer(e);
            }
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
        
        return result;
    }

    /**
     * 阻塞获取元素
     */
    public Map<String, String> take() throws InterruptedException{
        final ReentrantLock lock = this.lock;
        lock.lock();

        //1.先非阻塞取优先队列
        Map<String, String> element = null;
        try {
            element = firstQueue.poll();
            if (element == null) {
                //如果为空，非阻塞获取二级队列里面的异步任务
                element = secondQueue.poll();
                if (element == null) {
                    //如果任为空，说明整个队列为空，则阻塞获取优先队列
                    while (firstQueue.size() == 0) {
                        notEmpty.await();
                    }
                    element = firstQueue.poll();
                }
            }
        } finally {
            lock.unlock();
        }
        return element;
    }

    public static void main(String[] args) throws InterruptedException{
        DoubleBlockingQueue doubleBlockingQueue = new DoubleBlockingQueue(3);
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Map<String, String> consumerMap = doubleBlockingQueue.take();
                    if (consumerMap.containsKey("async")) {
                        //异步处理
                        sendHttpPost();
                        System.out.println("---------第" + consumerMap.get("no") +"个任务异步执行---------");
                    } else {
                        Thread.sleep(200L);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //生产端
        for (int i = 0; i < 1000; i++) {
            final int j = i;
            new Thread(() -> {
                Map<String, String> map = new HashMap<>();
                map.put("no", j + "");
                boolean result = doubleBlockingQueue.offer(map);
                if (result) {
                    //同步处理
                    sendHttpPost();
                    System.out.println("+++++++++第" + j +"个任务同步执行+++++++++");
                }
            }).start();
        }


        consumer.start();

        consumer.join();
        System.out.println("*************************************************");
    }

    public static void sendHttpPost(){
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 因为生产者是多线程的，当瞬间进来n多请求时，会迅速打满优先队列，剩余全部落到二级队列
 * 虽然消费的时候很很慢
 */
