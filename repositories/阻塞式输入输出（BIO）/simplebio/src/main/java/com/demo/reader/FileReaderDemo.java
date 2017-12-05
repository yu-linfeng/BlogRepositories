package com.demo.reader;

import java.io.FileReader;
import java.io.Reader;

/**
 * Created by Kevin on 2017/12/4 0004.
 */
public class FileReaderDemo {
    public static void main(String[] args) throws Exception{
        Reader reader = new FileReader("E:\\IdeaProjects\\simplebio\\src\\main\\java\\com\\demo\\inputstream\\test.json");
        char[] c = new char[64];
        reader.read(c);
        System.out.println(String.valueOf(c));
    }
}
