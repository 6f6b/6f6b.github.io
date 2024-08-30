package com.company.io;

import java.io.*;

/**
 * @author LiuFeng
 */
public class ByteStreamDemo {
    public static void main(String[] args) throws Exception{
        //读、写
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("/Users/feng/gits/JAVAWeb/工程/Java/pureJava/src/com/company/io/bytes_stream_in.txt");
            outputStream = new FileOutputStream("/Users/feng/gits/JAVAWeb/工程/Java/pureJava/src/com/company/io/bytes_stream_out.txt");
            int b;
            while ((b = inputStream.read()) != -1){
                outputStream.write(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != inputStream){
                inputStream.close();
            }
            if (null != outputStream){
                outputStream.close();
            }
        }
    }
}
