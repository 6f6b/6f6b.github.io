package com.company.p1;


import com.company.p2.AA;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

/**
 * @author LiuFeng
 */
public class C {
    public static void main(String[] args) {
        try {
            hel();
        }catch (Exception e){
            e.getStackTrace()
        }
//        System.out.println("hello1");
//        if (true){
//            throw new FileNotFoundException();
//        }
//        System.out.println("hello2");
    }



    public static List<? extends A> hel() throws FileNotFoundException{
        throw new FileNotFoundException();
    }
}
