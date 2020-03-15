package com.example.demo.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/15
 * @time 15:02
 */
public class ImageCopyDemo {
    @Test
    public void copy() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/001.jpg"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/resources/001_copy.jpg"));
        byte[] bytes = new byte[1000];
        int len;
        long startTime = System.nanoTime();
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
        fileInputStream.close();
        fileOutputStream.close();
    }
}
