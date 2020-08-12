package com;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class CommandManager  {
    Command command;

    public void excute(){
        this.command = createCommand();
        System.out.println(command.name);
    }

    public abstract Command createCommand();
}
