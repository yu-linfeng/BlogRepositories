package com.demo.blocking;

/**
 * Created by Kevin on 2017/12/5.
 */
public class DoSomethindThread implements Runnable {
    @Override
    public void run() {
        System.out.println("do something without i/o");
    }
}
