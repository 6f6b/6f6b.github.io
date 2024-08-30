package com.company;

/**
 * @author LiuFeng
 */
public class ThreadDemo1 {
    public static boolean seted = false;
    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始查询..");
                while (!seted){
                }
                System.out.println("已经被设置");
            }
        }).start();
        Thread.sleep(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始设置");
                seted = true;
                System.out.println("设置结束");
            }
        }).start();
    }
}
