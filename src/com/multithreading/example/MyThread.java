package com.multithreading.example;

class MyThread extends Thread {
    String name;

    MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 50; i++)
            System.out.println(name);
    }
}
