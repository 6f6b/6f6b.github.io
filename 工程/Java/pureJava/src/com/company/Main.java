package com.company;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.concurrent.*;

public class Main implements PropertyChangeListener {
    transient Set<String> keySet;

    public static void main(String[] args) {
//        JBean bean = new JBean();
//        bean.addPropertyChangeListener(new Main());
//        bean.setAge(1);
//        bean.setAge(2);
//        int[] ars = new int[10];
//        int[] a = {1,2};
//        int[] b = {3,4};
//        printNums(a,b);
//        Animal animal = new Animal();
//        String name = animal.name;
//
//        int num = 11;
//        for (int i = 0; i < 36; i++) {
//            num = ((num << 1)+1);
//
//            System.out.println("左移" + i+"位="+num);
//        }
        CompletableFuture
        for (int binCount = 0; ; ++binCount) {
            System.out.println(binCount);
            if (binCount >= 7) // -1 for 1st
                break;
        }
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1<<30) ? 1<<30 : n + 1;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.toString());
    }


    public static void printNums(int[]... numss){
        for (int[] nums : numss){
            for (int num : nums ){
                System.out.println("num---->"+String.format("%d",num));
            }
        }
    }

}
