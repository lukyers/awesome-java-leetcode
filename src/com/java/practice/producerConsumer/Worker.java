package com.java.practice.producerConsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by richard02.zhang on 18/2/7.
 * 生产者消费者模式 阻塞队列实现
 */
public class Worker {
    
    private int maxSize;
    
    private List<Date> storage;
    
    public Worker(int maxSize) {
        this.maxSize = maxSize;
        this.storage = new LinkedList<>();
    }
    
    public synchronized void put() {
        try {
            while (storage.size() == maxSize) {
                System.out.println(Thread.currentThread().getName()+": wait \n");
                wait();
            }
            storage.add(new Date());
            System.out.println(Thread.currentThread().getName()+": put: "+storage.size()+"\n");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public synchronized void take() {
        try {
            while (storage.size() == 0) {
                System.out.println(Thread.currentThread().getName()+": wait \n");
                wait();
            }
            Date d = ((LinkedList<Date>)storage).poll();
            System.out.println(Thread.currentThread().getName()+": d :" + d.toString() +": take: "+storage.size()+"\n");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                new Thread(producer, "producer-"+i).start();
            } else {
                new Thread(consumer, "consumer-"+(i-5)).start();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.shutdown();
        consumer.shutdown();
    }
}
