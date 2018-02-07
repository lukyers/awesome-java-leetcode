package com.java.practice.producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by richard02.zhang on 18/2/7.
 */
public class Consumer implements Runnable {
    
    private final BlockingQueue<Integer> blockingQueue;
    
    private volatile boolean flag;
    
    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
        this.flag = false;
    }
    
    @Override
    public void run() {
        while (!flag) {
            int info;
            try {
                info = blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+" consumer "+info+"\n");
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void shutdown() {
        flag = true;
    }
}
