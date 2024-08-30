package com.company;

import java.util.Set;

public class Problem implements InterfaceTest{
    String s;
    transient Set<String> keySet;

    class Inner {
        void testMethod() {
            s = "Set from Inner";
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1,2,3,4};

    }

}
