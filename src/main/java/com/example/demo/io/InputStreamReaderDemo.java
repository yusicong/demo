package com.example.demo.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/16
 * @time 22:15
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) {
        demo();
    }

    public static void demo() {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(
                    new FileInputStream("src/main/resources/result.txt"), StandardCharsets.UTF_8);
            char[] data = new char[1024];
            int len;
            while ((len = inputStreamReader.read(data)) != -1) {
                System.out.print(new String(data, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
