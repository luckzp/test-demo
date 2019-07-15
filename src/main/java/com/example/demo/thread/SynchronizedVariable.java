package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

/**
 * @author ZhangP
 * @since 2019-06-12 18:43
 */
public class SynchronizedVariable {

    public static int ticket = 20;

    // 创建一个静态钥匙
    public static Object lock = "aa";

    /**
     * 定义重入锁，对比性能
     */
    private static Lock reentrantLock = new ReentrantLock();

    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static ReadWriteLock rwlock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        for (int k = 0; k < 4; k++) {
            executor.submit(() -> {

                        while (ticket > 0) {
                            // 这个很重要，必须使用一个锁，
                            // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来。
                            // 注：synchronized是一个悲观锁，通常用于写入比较频繁的操作。
                            //synchronized (synchronizedLock) {
                            // reentrantLock.lock();
                            rwlock.readLock().lock();
                                if (ticket > 0) {
                                    System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket + "张票");
                                    rwlock.readLock().unlock();
                                    rwlock.writeLock().lock();
                                    ticket = ticket - 1;
                                    rwlock.writeLock().unlock();
                                } else {
                                    System.out.println("票卖完了");
                                }
                            // reentrantLock.unlock();
                            //}
                            try {
                                //休息一秒，其他线程创建
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );

        }
    }
}
