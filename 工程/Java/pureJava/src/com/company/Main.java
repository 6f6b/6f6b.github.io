package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    interface I1{
        void sayHello();
    }
    public static void main(String[] args) {
//        OuterStaticClass
//        Problem problem = new Problem();
        InterfaceTest.sayHello();
        long n = 461012;
//        String str = "sdfghjklsdfghjklsdfghjklsdfghjklsdfghjklsdfghjklsdfghjklsdfghjklsdfghjklsdfghjklsdfghjklsdfghjklsdfghjkl"
//        + "niubi";
//        String sub = str.substring(0);
//        String first = "hellofenghah";
//        String second = "pin feng";
//        boolean e = first.regionMatches(5,second,4,5);
//        System.out.println(e ? "匹配" : "不匹配");
//        System.out.format(str);      //  -->  "461012"
//        System.out.format("%08d%n", n);    //  -->  "00461012"
//        System.out.format("%+8d%n", n);    //  -->  " +461012"
//        System.out.format("%,8d%n", n);    // -->  " 461,012"
//        System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
//        StringBuilder builder = new StringBuilder();
//        builder.append(true);
//        System.out.println(builder);
        class C1{
        }
        class C2{
        }

        class C3<T extends C2 & I1>{
            
        }
        class WildcardError {

            void foo(List<?> i) {
                Object o =  i.get(0);
                List<String> strings = new ArrayList<String>() ;
                String[] strs = {};
            }
        }
    }
}
