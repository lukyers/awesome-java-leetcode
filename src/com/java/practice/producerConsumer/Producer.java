package com.java.practice.producerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by richard02.zhang on 18/2/7.
 */
public class Producer implements Runnable {
    
    private final BlockingQueue<Integer> blockingQueue;
    
    private volatile boolean flag;
    
    private Random random;
    
    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
        this.flag = false;
        this.random = new Random();
    }
    
    @Override
    public void run() {
        while (!flag) {
            int info = random.nextInt(100);
            try {
                blockingQueue.put(info);
                System.out.println(Thread.currentThread().getName()+"producer "+info+"\n");
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
