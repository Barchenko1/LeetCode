package com.test.concurrent;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static class MyRunnable implements Runnable {

        private int count = 0;

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (this) {
                    count++;
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + this.count);
        }
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("myThread");
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();

//        Runnable runnable = () -> {
//            String name = Thread.currentThread().getName();
//            System.out.println(name + " running");
//        };
//
//        Thread thread1 = new Thread(runnable, "thread1");
//        thread1.start();
//        Thread thread2 = new Thread(runnable, "thread2");
//        thread2.start();

//        Runnable runnable = () -> {
//            for (int i = 0; i < 5; i++) {
//                sleep(1000);
//                System.out.println("Running");
//            }
//        };
//
//        Thread thread = new Thread(runnable);
//        thread.setDaemon(true);
//        thread.start();
//
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        Runnable runnable = new MyRunnable();
//
//        Thread thread1 = new Thread(runnable, "Thread1");
//        Thread thread2 = new Thread(runnable, "Thread2");
//
//        thread1.start();
//        thread2.start();

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        executorService.execute(newRunnable("task 1"));
//        executorService.execute(newRunnable("task 2"));
//        executorService.execute(newRunnable("task 3"));

//        Future future = executorService.submit(newRunnable("future"));
//        System.out.println(future.isDone());
//
//        try {
//            Object object = future.get();
//            System.out.println(object);
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(future.isDone());

        SynchronizeClass synchronizeClass1 = new SynchronizeClass();

        MyThread runnable1 = new MyThread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronizeClass1.setObject("" + i);
                }
            }
        };

        MyThread runnable2 = new MyThread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(synchronizeClass1.getObject());
                }
            }
        };


        runnable2.start();
        runnable1.start();
    }

    private static Runnable newRunnable(String text) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + text);
            }
        };
    }

    private static Callable newCallable(String text) {
        return new Callable() {

            @Override
            public Object call() throws Exception {
                return Thread.currentThread().getName() + ":" + text;
            }
        };
    }

}
