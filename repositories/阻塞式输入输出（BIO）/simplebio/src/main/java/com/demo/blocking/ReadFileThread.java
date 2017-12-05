package com.demo.blocking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Kevin on 2017/12/5.
 */
public class ReadFileThread implements Runnable{

    @Override
    public void run() {
        try (InputStream in = new FileInputStream("E:\\IdeaProjects\\simplebio\\src\\main\\java\\com\\demo\\inputstream\\test.json")){
            byte[] buffer = new byte[64];
            in.read(buffer);
            System.out.println(new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
