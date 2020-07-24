package com.example.demo.io;

import java.io.*;

/**
 * Create by idea
 * buffered提供了缓冲区大大提高了大文件的处理速度
 * 2G的视频的复制时间大概可以缩短到原有时间的1/4时间
 *
 * @author yusicong
 * @date 2020/3/15
 * @time 22:14
 */
public class BufferedStreamDemo {

    public static void main(String[] args) {
        String sourceSrc = "D:\\英雄时刻\\49847123\\英雄时刻_20200302-22点25分47s.avi";
        String targetSrc = "D:\\BaiduNetdiskDownload\\课件笔记源码资料2.avi";
        copyByBuffered(sourceSrc,targetSrc);//6502
//        copyByNormalStream(sourceSrc, targetSrc);//30505
    }

    public static void copyByBuffered(String sourceSrc, String targetSrc) {
        long startTime = System.currentTimeMillis();
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            FileInputStream inputStream = new FileInputStream(sourceSrc);
            bufferedInputStream = new BufferedInputStream(inputStream);

            FileOutputStream fileOutputStream = new FileOutputStream(targetSrc);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[2048];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("copyByBuffered cost time:" + (System.currentTimeMillis() - startTime));
    }

    public static void copyByNormalStream(String sourceSrc, String targetSrc) {
        long startTime = System.currentTimeMillis();

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(sourceSrc);
            FileOutputStream fileOutputStream = new FileOutputStream(targetSrc);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("copyByNormalStream cost time:" + (System.currentTimeMillis() - startTime));
    }
}
