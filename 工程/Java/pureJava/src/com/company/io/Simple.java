package com.company.io;

import java.io.*;

/**
 * @author LiuFeng
 */
public class Simple {
    public static void main(String[] args) {
        InputStream inputStream;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        Console console = System.console();
        if (console != null){
            String str = console.readLine();
            console.writer().println("输入了："+str);
        }
    }
}
