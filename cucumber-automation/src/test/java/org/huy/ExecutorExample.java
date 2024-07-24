package org.huy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            final int threadNumber = i;
            executorService.submit(() -> {
                Thread.currentThread().setName("Thread-"+ threadNumber);
                System.out.println("Thread " + threadNumber + " is running. " + Thread.currentThread().getName());
            });
        }
        System.out.println("Thread Main is running. " + Thread.currentThread().getName());
        executorService.shutdown();
    }
}
