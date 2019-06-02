package com.wan.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by 万亚明 on 2019/5/2.
 */
public class IO {
    public static void main(String[] args) {
        createFile();
    }

    public static void createFile(){
        File file = new File("D:\\source\\core-java\\txt\\io.txt");

        try {
            if (!file.exists()) {
                file.mkdirs();
                file.createNewFile();
                System.out.println(file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
