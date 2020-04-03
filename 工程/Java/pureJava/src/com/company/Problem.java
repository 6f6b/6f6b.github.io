package com.company;

public class Problem implements InterfaceTest{
    String s;
    class Inner {
        void testMethod() {
            s = "Set from Inner";
        }
    }

}
