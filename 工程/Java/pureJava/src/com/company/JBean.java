package com.company;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class JBean {
    private int age;
    private PropertyChangeSupport support;

    public JBean(){
        this.support = new PropertyChangeSupport(this);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int oldAge = this.age;
        int newAge = age;
        this.age = age;
        PropertyChangeEvent event = new PropertyChangeEvent(this,"age",oldAge,newAge);
        this.support.firePropertyChange(event);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
        System.out.print("添加Listener");
    }

    public void removePropertyChangeListener(PropertyChangeListener listener){
        support.removePropertyChangeListener(listener);
        System.out.print("移除Listener");
    }
}
