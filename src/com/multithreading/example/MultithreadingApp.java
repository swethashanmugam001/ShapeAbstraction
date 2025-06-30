package com.multithreading.example;

/*Multi-threading with join example*/

public class MultithreadingApp {

    public static void main(String[] args) {

        MyThread thread1 = new MyThread("Ravinder");

        MyThread thread2 = new MyThread("Anuradha");

        MyThread thread3 = new MyThread("Divya");

        thread1.start();

        try
        {
            thread1.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread1 interrupted");
        }

        thread2.start();

        try
        {
            thread2.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Thread2 interrupted");
        }

        thread3.start();

        try
        {
            thread3.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread 3 interrupted");
        }

    }
}
