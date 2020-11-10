package DeadLock;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public Lock lock = new ReentrantLock();

    public void sayHello(){
        Callable
        System.out.println(String.format("%s 进入函数",Thread.currentThread().getName()));
        lock.lock();
        System.out.println(String.format("%s 拿到锁",Thread.currentThread().getName()));
        try {
            System.out.println(String.format("%s 执行操作并休息4秒",Thread.currentThread().getName()));
            Thread.sleep(4000);
        }catch (Exception e){

        }
        finally {
            System.out.println(String.format("%s 准备释放锁",Thread.currentThread().getName()));
            lock.unlock();
            System.out.println(String.format("%s 释放锁成功",Thread.currentThread().getName()));
        }
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    lockDemo.sayHello();

                }
            }
        },"线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    lockDemo.sayHello();
                }
            }
        },"线程2").start();
    }
}
