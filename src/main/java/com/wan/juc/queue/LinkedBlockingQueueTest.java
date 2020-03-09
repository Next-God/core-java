package com.wan.juc.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author wanyaming
 * @since 2020年2月12日 下午9:46:12
 */
public class LinkedBlockingQueueTest {
    static class Mytask implements Runnable {
        @Override
        public void run() {
            System.out.println("==========" + Thread.currentThread());
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * LinkedBlockingQueue可以设置成有界队列
     * @param args
     */
    public static void main(String[] args) {
        doPut();
    }

    /**
     * 满的时候会抛异常
     */
    private static void doAdd(){
        LinkedBlockingQueue<Integer> list = new LinkedBlockingQueue<>(5);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        System.out.println(list);
    }

    /**
     * 阻塞
     */
    private static void doPut(){
        LinkedBlockingQueue<Integer> list = new LinkedBlockingQueue<>(3);
        for (int i = 0; i < 10; i++) {
            try {
                list.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list);
    }

    private static void doExecutor() {
        ExecutorService threadPool = new ThreadPoolExecutor(3, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Thread(new Mytask()));
        }

        threadPool.shutdown();
    }

    private static void doOffer() {
        LinkedBlockingQueue<Integer> list = new LinkedBlockingQueue<>(3);
        for (int i = 0; i < 10; i++) {
            System.out.println("=============" + i + "次操作成功" + list.offer(1));
        }
    }
}
