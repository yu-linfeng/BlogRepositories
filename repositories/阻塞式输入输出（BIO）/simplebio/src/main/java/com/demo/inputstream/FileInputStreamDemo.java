package com.demo.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Kevin on 2017/12/4.
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        try {
            File file = new File("E:\\IdeaProjects\\simplebio\\src\\main\\java\\com\\demo\\inputstream\\test.json");
            InputStream in = new FileInputStream(file);
            byte[] b = new byte[64];
            in.read(b);
            System.out.println(new String(b));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
