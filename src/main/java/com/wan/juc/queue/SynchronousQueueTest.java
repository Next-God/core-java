package com.wan.juc.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue不存储元素，每个#put必须等待一个#take
 * @author wanyaming
 * @since 2020年2月12日 下午10:28:51
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> sq = new SynchronousQueue();
        sq.put(1);
        System.out.println(sq);
    }
}
