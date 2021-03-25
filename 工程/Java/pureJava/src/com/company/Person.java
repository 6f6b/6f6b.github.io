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
}
