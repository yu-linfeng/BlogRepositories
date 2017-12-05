package com.demo.blocking;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Kevin on 2017/12/5 0005.
 */
public class BlockingDemo {
    public static void main(String[] args) {
        new Thread(() -> readFile()).start();
        doSomething();
    }

    /**
     * 读取文件
     */
    private static void readFile() {
        try (InputStream in = new FileInputStream("E:\\IdeaProjects\\simplebio\\src\\main\\java\\com\\demo\\inputstream\\test.json")) {
            byte[] b = new byte[64];
            in.read(b);
            System.out.println(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * do something.
     */
    private static void doSomething() {
        System.out.println("do something.");
    }
}
