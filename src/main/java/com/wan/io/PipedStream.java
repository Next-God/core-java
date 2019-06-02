package com.wan.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流
 *      输入和输出不能再一个线程里，否者会死锁
 * Created by 万亚明 on 2019/5/2.
 */
public class PipedStream {
    public static void main(String[] args) throws IOException{
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);

        Thread t1 = new Thread(() -> {
            try{
                output.write("Hello world".getBytes());
                output.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try{
                int data = input.read();

                while(data != -1) {
                    System.out.print((char)data);
                    data = input.read();
                }

                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
