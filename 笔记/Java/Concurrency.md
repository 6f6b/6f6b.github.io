# 并发相关

# Processes and Threads

A computer system normally has many active processes and threads. This is true even in systems that only have a single execution core, and **thus only have one thread actually executing at any given moment**. Processing time for a single core is shared among processes and threads through an OS feature called **time slicing**.

## Processes

A process has a **self-contained execution environment**. A process generally has a complete, private set of basic run-time resources; in particular,**each process has its own memory space**.

Processes are often seen as synonymous with programs or applications. However, **what the user sees as a single application may in fact be a set of cooperating processes**. To facilitate communication between processes, most operating systems support *Inter Process Communication* (IPC) resources, such as pipes and sockets. IPC is used not just for communication between processes on the same system, but processes on different systems.

## Threads

Threads are sometimes called**lightweight processes**. Both processes and threads provide an execution environment, but creating a new thread requires fewer resources than creating a new process.

Threads exist within a process — every process has at least one. Threads share the process's resources, including memory and open files. This makes for efficient, but potentially problematic, communication.

Multithreaded execution is an essential feature of the Java platform. Every application has at least one thread — or several, if you count "system" threads that do things like memory management and signal handling. But from the application programmer's point of view, you start with just one thread, **called the *main thread*. This thread has the ability to create additional threads**, as we'll demonstrate in the next section.





Questions：

1. 什么是多线程？

   > 多线程就是多个线程，与其问什么是多线程不如问什么是线程，线程解释如上所示

2. 什么是多进程？

   > 多进程同理，就是多个进程

3. 什么是并发？

4. 什么是串行

5. 什么是异步？

6. 什么是同步？



###二、多线程引起的两个问题

1. 线程干扰

   > 由于代码中的一个简单表达式在实际运行的时候实际上是多个步骤，当执行多线程操作时这些步骤就有可能发生覆盖，导致错误

2. 内存一致性问题

   > 通俗的来讲就是A线程发生在内存上的操作对B线程来讲不可见（造成不可见的根本原因据说是很复杂的，不在多线程的讨论范围内），导致错误产生。
   >
   > 解决方案：
   >
   > 1. 建立happens-before关系，目前有下面几种方法建立了happens-before关系
   >
   >    1. Thread.start，与这个表达式具有happens-before关系的所有表达式都与该新线程中的表达式具有happens-before关系
   >    2. Thread.join，join线程中的表达式与被join的线程中join表达式后面的所有表达式都具备happens-before关系
   >    3. 更多创建happens-before关系的操作详见[Summary page of the `java.util.concurrent` package.](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html#MemoryVisibility).
   >
   > 2. 同步(synchronization)，同步分为方法同步和表达式同步。同步一个方法或一段代码实际上是进行了两个操作：一是上锁；二是建立happens-before关系（该操作避免了内存一致性问题）
   >
   >    ```java
   >    1.方法同步
   >    public class SynchronizedCounter {
   >        private int c = 0;
   >    		//在方法声明的地方加上synchronization关键字即可
   >        public synchronized void increment() {
   >            c++;
   >        }
   >    }
   >    2.表达式同步
   >    public void addName(String name) {
   >      //表达式这里之所以需要一个this(也可以是其他对象)，是因为同步的实现原理是通过对象内部的一个锁(intrinsic lock)来实现
   >        synchronized(this) {
   >            lastName = name;
   >            nameCount++;
   >        }
   >      //下面的表达式为什么不放入到synchronized表达是因为add方法也可能是个synchronized方法，那么线程A在访问addName的时候，A拿到了addName所在对象的锁，此时又要拿nameList的锁肯定拿不到的，需要释放了A的锁才能拿nameList的锁。
   >        nameList.add(name);
   >    }
   >    ```
   >
   >    > 同步又会导致新的问题，那就是线程争用，线程争用导致线程执行变慢，此外还可能导致线程停止。**饥饿锁**和**liveLock**就是线程争用的表现形式

3. 原子操作：顾名思义原子操作即为不可分割的操作，根据线程干扰的原理可以推出原子操作能够避免线程干扰，但是并**不能消除内存一致性问题**，通过`volatile`关键字修饰的变量可以**减少**内存一致性问题，因为任何对volatile变量的读操作都会建立一个happens-before关系（为什么是减少而不是避免？）。下面的操作可以认为其是原子操作

   1. 对引用的读写操作以及大多数基础数据类型的读写操作（除了long和double）
   2. 对所有加了volatile关键字的变量的读写操作
   3. 更多的原子性操作方法详见[`java.util.concurrent`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html) 

   > 使用原子操作相比于使用synchronized效率更高、性能更好，但是需要开发人员更加小心以避免内存一致性错误

4. Liveness（活跃性问题）

   1. 死锁

      > 两个线程A、B访问两个对象O1、O2的同步方法，在O1和O2的同步方法中又互相访问了对方的同步方法，那么就可能造成死锁

   2. 饥饿锁

      > 某个对象的同步方法耗时长且频繁被某个线程调用，造成其他线程无法获取到这个对象的锁

   3. 活跃锁

      > k

5. Guarded Blocks

   > 保护块用来实现在线程中需要等待某一条件达成后再继续往下执行这一需求，这个需求也可以通过while轮询来实现，但这样系统开销会很高
   >
   > ```java
   > class A {
   > 	//这里之所以要用synchronized关键字是因为调用wait方法的线程必须要持有A对应对象的内部锁，否则会发生错误。
   >   public synchronized void guardedJoy() {
   >       while(!condition) {
   >           try {
   >             	//当T1调用这个方法后，线程释放其持有的锁，并且该线程进入休眠状态，等待唤醒
   >               wait();
   >           } catch (InterruptedException e) {}
   >       }
   >       System.out.println("Joy and efficiency have been achieved!");
   >   }
   > 	
   >   //这里之所以要用synchronized关键字是因为调用notifyAll方法的线程必须要持有A对应对象的内部锁，否则会发生错误。
   >   public synchronized notifyJoy() {
   >       joy = true;
   >     	//当Tx调用该方法时，唤醒了等待该对象的线程即上面的T1，当Tx执行完毕，T1拿到锁，继续往下执行
   >       notifyAll();
   >   } 
   > }
   > ```
   >
   > 

几个关键接口：

1. Thread

   > 开启一个新线程，调用start方法执行其内部target<Runable>的run方法

2. Executor

   > void execute(Runnable command);其实现类实现了怎么execute

   1. ExecutorService

      > <T> Future<T> submit(Callable<T> task);其实现类实现了提交execute的内容，并返回一个Future

   2. gf

      > public ScheduledFuture<?> schedule(Runnable command,long delay, TimeUnit unit);其实现类实现了可延迟execute提交的内容，并返回一个ScheduledFuture

3. Future

   > 提供给外部操作线程，如取消、获取线程执行结果

4. Runable

   > run方法中定义要run什么