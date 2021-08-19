package com.company;

import java.math.BigDecimal;

public class Person extends AbstractPerson{
    String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void sayHello() {
    }

    public static void main(String[] args) throws Exception{
        String a = new String("abc");
        new String("bcd");
        Person person = new Person();
        Thread.sleep(1000000);
    }

}
