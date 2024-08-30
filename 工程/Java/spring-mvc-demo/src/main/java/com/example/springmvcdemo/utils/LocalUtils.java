package com.example.springmvcdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class LocalUtils {
    @Autowired
    public static MessageSource messageSource;
}
