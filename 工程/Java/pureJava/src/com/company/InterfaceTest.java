package com.company;

public interface InterfaceTest {
    public static void sayHello(){
        System.out.print("Hello feng");
    }
    public interface SomethingIsWrong {
       default void aMethod(int aValue){
            System.out.println("Hi Mom");
        }
        public interface Marker {
        }
    }
}
