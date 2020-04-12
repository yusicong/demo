package com.example.demo.io;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/15
 * @time 23:14
 */
public class BufferStatic {
    public static void main(String[] args) {
        SameCharacterStatistics("src/main/resources/史上最强店主[bookben.net].txt", "src/main/resources/result.txt");
    }

    public static void SameCharacterStatistics(String statisticsSrc, String resultSrc) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        Map<String, Integer> statisticsMap = new HashMap<>();

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(statisticsSrc), "GB2312"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultSrc), "UTF-8"));
            int c;
            while ((c = bufferedReader.read()) != -1) {
                String charC = String.valueOf((char) c);
                Integer num = statisticsMap.get(charC);
                if (num == null) {
                    statisticsMap.put(charC, 1);
                    System.out.println(charC);
                } else {
                    statisticsMap.put(charC, ++num);
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(statisticsMap.entrySet());
            //升序排序
            list.sort((o1, o2) -> o2.getValue() - o1.getValue());

            String statisticsMapJson = JSON.toJSONString(list, true);
            System.out.println(statisticsMapJson);
            bufferedWriter.write(statisticsMapJson);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
