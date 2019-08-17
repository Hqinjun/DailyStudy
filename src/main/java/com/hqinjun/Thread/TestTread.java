package com.hqinjun.Thread;

public class TestTread {
    public  static int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final TestTread test = new TestTread();
        Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println( Thread.currentThread().getName()+this.getName());
            }
        };
        thread.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName());

            }
        });
        thread2.start();


//        while(Thread.activeCount()<1)  //保证前面的线程都执行完
//            Thread.yield();
        System.out.println(test.inc);
    }
}

