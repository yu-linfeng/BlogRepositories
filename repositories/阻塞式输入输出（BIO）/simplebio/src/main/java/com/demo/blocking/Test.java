package com.demo.blocking;

/**
 * Created by Kevin on 2017/12/5.
 */
public class Test {
    public static void main(String[] args) {
        Thread readFileThread = new Thread(new ReadFileThread());
        Thread doSomethingThread = new Thread(new DoSomethindThread());
        readFileThread.start();
        doSomethingThread.start();
    }
}
