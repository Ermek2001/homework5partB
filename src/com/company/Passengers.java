package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passengers extends Thread {
    private int passengerNumber;
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;

    public Passengers(int passengerNumber, Semaphore semaphore, CountDownLatch countDownLatch){
        this.passengerNumber = passengerNumber;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        try {
            semaphore.acquire();
            System.out.println(passengerNumber + "get a ticket");
            Thread.sleep(5000);
            System.out.println(passengerNumber + "gets the ticket");
            semaphore.release();
            Thread.sleep(4000);
            countDownLatch.countDown();
            System.out.println(passengerNumber + "take a sit on the bus");
            Thread.sleep(5000);
            countDownLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
