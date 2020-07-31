package com;

import java.beans.PropertyEditorSupport;

public class DogEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        Dog dog = new Dog();
        dog.name = s;
        setValue(dog);
    }
}