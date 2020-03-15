package com.example.demo.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/15
 * @time 12:44
 */
public class FileReaderWriterTest {

    /**
     * FileReader
     * 说明点:
     * 1. read()的理解: 返回读入的一个字符。如果达到文件末尾，返回-1
     * 2.异常的处理:为了保证流资源一定可以执行关闭操作。需要使用
     * try-catch-finally处理
     */
    @Test
    public void testFileReader() {
        File file = new File("src/main/resources/test.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileReader01() throws IOException {
        File file = new File("src/main/resources/test.txt");
        FileReader fileReader = new FileReader(file);
        char[] chars = new char[5];
        int len;
        StringBuffer stringBuffer = new StringBuffer();
        while ((len = fileReader.read(chars)) != -1) {
            stringBuffer.append(chars, 0, len);
        }
        System.out.println(stringBuffer);
    }

    @Test
    public void testFileWriter01() throws IOException {
        File file = new File("src/main/resources/Writer.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("我是你爸爸\n");
        fileWriter.write("我是你爷爷");
        fileWriter.close();
    }

    /**
     * 复制方法
     * @throws IOException 异常
     */
    @Test
    public void copyFile() throws IOException {
        //不能使用字符流处理图片等字节流文件
        FileReader fileReader = new FileReader(new File("src/main/resources/Writer.txt"));
        FileWriter fileWriter = new FileWriter("src/main/resources/WriterCopy.txt");
        char[] chars = new char[5];
        int len;
        while ((len = fileReader.read(chars)) != -1) {
            fileWriter.write(chars, 0, len);
        }
        fileReader.close();
        fileWriter.close();
    }
}
