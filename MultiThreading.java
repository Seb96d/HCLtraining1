package com.company;
import static java.lang.Thread.*;

public class MultiThreading extends Thread{

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
//        MyCounter myCounter = new MyCounter();

        Thread printOdd = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 20) {
                    if (i % 2 == 1) {
                        System.out.println(i);
                        i = i + 1;
                        try {
                            synchronized (this) {
                                wait();
                                notifyAll();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        Thread printEven = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 20) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                        i = i + 1;
                        try {
                            synchronized (this) {
                                wait();
                                notifyAll();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        printOdd.start();
        printEven.start();
    }

}

//static class PrintOdd extends Thread {
//    public void run() {
//        if (myNumber % 2 == 1 && myNumber <= 20) {
//            System.out.println(myNumber);
//            myNumber++;
//            Test4.PrintEven printEven = new Test4.PrintEven();
//            printEven.start();
//        }
//    }
//}
/// Thread  ==
// Synchronized Thread ==
// non synchronized  Thread ==
// sleep  and wait
// Runnable interface
// ---> Main Odd==> PrintOdd => wait ==> awake ==> PrintEven ==> Print ==> wait ==> awake => odd ==>
// Thread-safe /
//