package com.feng.spider;

import java.util.Random;

/**
 * @author liufeng
 * @date 2021/11/20 11:32 上午
 */

public class RunApplication {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.println(random.nextInt(2));
        }
    }
}
