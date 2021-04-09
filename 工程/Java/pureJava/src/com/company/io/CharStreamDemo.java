package com.company.io;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author LiuFeng
 */
public class CharStreamDemo {
    public static void main(String[] args) throws Exception{
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("/Users/feng/gits/JAVAWeb/工程/Java/pureJava/src/com/company/io/bytes_stream_in.txt");
            fileWriter = new FileWriter("/Users/feng/gits/JAVAWeb/工程/Java/pureJava/src/com/company/io/bytes_stream_out.txt");
            int c;
            while ((c = fileReader.read()) != -1){
                fileWriter.write(c);
            }
        }catch (Exception e){
        }
        finally {
            if (fileReader != null){
                fileReader.close();
            }
            if (fileWriter != null){
                fileWriter.close();
            }
        }
    }
}
