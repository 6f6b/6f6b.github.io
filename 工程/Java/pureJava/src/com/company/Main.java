package com.company;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main implements PropertyChangeListener {
    transient Set<String> keySet;

    public static void main(String[] args) {
        JBean bean = new JBean();
        bean.addPropertyChangeListener(new Main());
        bean.setAge(1);
        bean.setAge(2);
        int[] ars = new int[10];
        int[] a = {1,2};
        int[] b = {3,4};
        printNums(a,b);
        Animal animal = new Animal();
        String name = animal.name;

        byte num = (byte) 0xff;
        byte num1 = (byte) ((num << 1));

        System.out.println(num);
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
