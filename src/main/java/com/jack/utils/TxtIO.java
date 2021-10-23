package com.jack.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 读写txt文件的工具类
 */
public class TxtIO {


    /**
     * 写入txt文件
     * 传入内容、文件全路径名，将内容写入文件并换行
     *
     * @param txtTitle 传入的内容
     * @param txtPath 写入的文件路径
     */
    public static void writeTxt(String txtTitle, String txtPath) {
        File file = new File(txtPath);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(txtTitle, 0, txtTitle.length());
            fileWriter.write("\n");
            // 关闭资源
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param txtPath 文件路径
     * @return 文件内容
     * @author jack
     * 读出txt文件
     * 传入文件绝对路径，将文件内容转化为 String字符串输出
     */
    public static String readTxt(String txtPath) {
        StringBuilder str = new StringBuilder();
        String strLine;
        // 将 txt文件按行读入 str中
        File file = new File(txtPath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 字符串拼接
            while ((strLine = bufferedReader.readLine()) != null) {
                str.append(strLine);
            }
            // 关闭资源
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
}

