package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(4);
        for (int i = 1; i <cdl.getCount() ; i++) {
            new Passengers(i, semaphore, cdl).start();

        }
        try {
            cdl.await();
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("We have got a message, all passengers on the bus will travell from the East side"+ "they enjoy their trip!");

    }
}
