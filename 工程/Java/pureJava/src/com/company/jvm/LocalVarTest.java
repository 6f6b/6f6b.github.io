package com.company.jvm;

import com.company.LocalClassExample;

import java.util.ArrayList;
import java.util.Random;

public class LocalVarTest {
    public static void main(String[] args) throws Exception{
        int a = 12;
        int b = 4;
        int c = a+b;
        String d = "feng";
        LocalVarTest test = new LocalVarTest();
        ArrayList<Image> images = new ArrayList<>();
        while (true){
            Thread.sleep(20);
            images.add(new Image(new Random().nextInt(1024*102)));
        }
    }

    static class Image{
        private byte[] pixes;

        Image(int length){
            pixes = new byte[length];
        }
    }

    public void hello(){
        int a = 12;
        int b = 4;
        int c = a+b;
        String d = "feng";
        LocalVarTest test = new LocalVarTest();
    }
}
