package com.wan.juc.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author wanyaming
 * @since 2020年2月13日 下午3:13:07
 */
public class ForkJoinPoolTest {
    public static void main(String[] args) {
        ForkJoinPool pool = (ForkJoinPool) Executors.newWorkStealingPool();
        pool.invoke(null);

    }
}
