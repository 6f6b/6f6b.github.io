package com.company;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Main implements PropertyChangeListener {
    public static void main(String[] args) {
        JBean bean = new JBean();
        bean.addPropertyChangeListener(new Main());
        bean.setAge(1);
        bean.setAge(2);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.toString());
    }
}
