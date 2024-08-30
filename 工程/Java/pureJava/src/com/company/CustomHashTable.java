package com.company;

import java.util.Hashtable;

/**
 * @Author LiuFeng
 * @Date 2021/1/25
 */
public class CustomHashTable extends Hashtable {

    public CustomHashTable(int initialCapa){
        super(initialCapa);
    }

    public void doReHash(){
        for (int i = 0; i < 33; i++) {
            System.out.println("----------"+i);
            this.rehash();
        }
    }
}
