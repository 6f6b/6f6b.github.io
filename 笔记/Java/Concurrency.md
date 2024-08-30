# 并发相关

### 一、简介

1. Processes and Threads

   A computer system normally has many active processes and threads. This is true even in systems that only have a single execution core, and **thus only have one thread actually executing at any given moment**. Processing time for a single core is shared among processes and threads through an OS feature called **time slicing**.

2. Processes

   A process has a **self-contained execution environment**. A process generally has a complete, private set of basic run-time resources; in particular,**each process has its own memory space**.

   Processes are often seen as synonymous with programs or applications. However, **what the user sees as a single application may in fact be a set of cooperating processes**. To facilitate communication between processes, most operating systems support *Inter Process Communication* (IPC) resources, such as pipes and sockets. IPC is used not just for communication between processes on the same system, but processes on different systems.

3. Threads

   Threads are sometimes called**lightweight processes**. Both processes and threads provide an execution environment, but creating a new thread requires fewer resources than creating a new process.

   Threads exist within a process — every process has at least one. Threads share the process's resources, including memory and open files. This makes for efficient, but potentially problematic, communication.

   Multithreaded execution is an essential feature of the Java platform. Every application has at least one thread — or several, if you count "system" threads that do things like memory management and signal handling. But from the application programmer's point of view, you start with just one thread, **called the *main thread*. This thread has the ability to create additional threads**, as we'll demonstrate in the next section.

### 二、打断

1. sleep

   > 让某个线程暂停工作，把处理器让给其他线程或应用，睡眠期间可能被打断

2. Interruption

   > 1. 打断是指示某个线程停下正在做的事，去做一些**其他事**。具体怎么响应打断由开发人员自行决定，通常情况下是结束这个线程
   >
   > 2. Question：某些具体的方法才可能抛出InterruptException，如：sleep、wait等，加入A线程运行的时间比较久，而其中又没有调用这些可能抛出InterruptException的方法，那该如何处理打断呢？
   >
   >    > 通过`Thread.Interrupted()`来判断是否被打断，进而处理打断。
   >
   > 3. 打断的实现机制是在线程内部有一个打断的flag，当执行`Thread.interrupt`的时候这个flag被设置，当调用`Thread.Interrupted()`来判断的时候被清空。

3. join

   > 如：在A线程中执行t.join表示在执行的地方等待t线程终止后再继续走A线程后续的代码

###二、多线程引起的两个问题

1. 线程干扰

   > 由于代码中的一个简单表达式在实际运行的时候实际上是**多个步骤**（编程的时候在大脑中假设它有N多个步骤），当执行多线程操作时这些步骤就有可能发生覆盖，导致错误

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
   >      //下面的表达式为什么不放入到synchronized表达是因为add方法也可能是个synchronized方法，那么线程A在访问addName的时候，A拿到了addName所在对象的锁，如果nameList的add方法也是同步方法且被其他线程调用则可能造成死锁。
   >        nameList.add(name);
   >    }
   >    ```
   >
   >    Note：
   >
   >    * 构造方法不能被同步（会报语法错误），因为在创建一个对象的时候只有创建它的线程才能访问到它
   >
   >    * 当心在一个线程中构造一个可能被多个线程使用的对象时避免过早的泄露该对象的引用
   >
   >      > 如：instances.add(this);this可能还没创建完成，但可能会被其他线程通过instances访问到，进而导致错误
   >
   >    > 同步又会导致新的问题，那就是线程争用，线程争用导致线程执行变慢，此外还可能导致线程停止。**饥饿锁**和**liveLock**就是线程争用的表现形式

3. 原子操作：顾名思义原子操作即为不可分割的操作，根据线程干扰的原理可以推出原子操作能够避免线程干扰，但是并**不能消除内存一致性问题**，通过`volatile`关键字修饰的变量可以**减少**内存一致性问题，因为任何对volatile变量的写操作都会对后续的读操作建立一个happens-before关系（为什么是减少而不是避免？）。下面的操作可以认为其是原子操作

   1. 对引用的读写操作以及大多数基础数据类型的读写操作（除了long和double）

   2. 对所有加了volatile关键字的变量的读写操作

      > volatile使得赋值操作被立即写回系统内存，并由MESI协议保证通知到其他处理器将相应工作内存中的变量失效处理

   3. 更多的原子性操作方法详见[`java.util.concurrent`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html) 

   > 使用原子操作相比于使用synchronized效率更高、性能更好，但是需要开发人员更加小心以避免内存一致性错误

4. Liveness（活跃性问题）

   1. 死锁

      > 两个线程A、B访问两个对象O1、O2的同步方法，在O1和O2的同步方法中又互相访问了对方的同步方法，那么就可能造成死锁
      >
      > 解决方案：
      >
      > 1. 分段锁

   2. 饥饿锁

      > 某个对象的同步方法耗时长且频繁被某个线程调用，造成其他线程无法获取到这个对象的锁
      >
      > 解决方案：
      >
      > 1. 公平分配策略

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

6. 不可变对象

   > 不可变对象可以帮助我们在高并发开发中写出更加简单、可靠的代码，因为其状态不会改变。频繁的创建对象对系统开销并不会有太大影响，此外不可变对象带来的便利和高效能够覆盖其增加的系统开销；垃圾收集可以减少频繁创建对象的系统开销（为什么？），因为不可变对象减少的保护可变对象的代码带来的系统开销。

### 三、高级并发对象

> 充分利用多处理器、多核；完成更高级的任务；

1. Lock

   > Lock 与 隐式的内部锁的区别是：当T1线程拿了O1对象的内部锁，T2再去拿O1对象的内部锁，则T2会被阻塞知道T1释放O1的锁；如果内部锁换成Lock的话，T2再去拿O1的lock就会告知失败，而不会阻塞该线程

2. Excutors

   > Excutors是用来干什么的？**在较小的应用中，我们通过手动new一个Thread来开启一个线程是合适的，但是在大的应用中最好把线程的创建和管理分离开来，而Excutors所代表的对象就封装了这样的一系列方法。**

   1. 几个关键类和接口

      > * Executor
      > * ExecutorService
      > * ScheduledExecutorService
      > * Executors 一个工厂类，提供了一些工厂方法用来直接生成上面三个接口的实现类的实例

   2. Thread Pools 线程池

      > **Using worker threads minimizes the overhead due to thread creation. Thread objects use a significant amount of memory, and in a large-scale application, allocating and deallocating many thread objects creates a significant memory management overhead.**
      >
      > 线程的创建和销毁需要巨大的内存管理开销

3. ForkJoinPool

   > 这个类实现了work-steal算法，让它来执行一个RecursiveTask或RecursiveAtion的实例可以将一个可以进行拆分的任务交个多个线程去执行

4. 并发集合

   > 并发集合（如：ConcurrentHashMap、ConcurrentSkipListMap）通过在增加或删除一个对象的操作后添加happens-before关系来避免内存一致性错误

5. Atomic Variables

   > **AtomicInteger 和 Integer在前面加volatile关键字的区别是什么？**

6. Concurrent Random Numbers

   > 在多线程中需要用到随机数时使用ThreadLocalRandom来生成随机数，相比于Math.random()线程争执更少、性能更好
   >
   > ```java
   > int r = ThreadLocalRandom.current() .nextInt(4, 77);
   > ```



Questions：

1. 什么是多线程？

   > 多线程就是多个线程，与其问什么是多线程不如问什么是线程，线程解释如上所示

2. 什么是多进程？

   > 多进程同理，就是多个进程

3. 什么是并发？

   > 一个处理器分时处理多个任务

4. 什么是并行

   > 多个处理器处理多个任务

5. 什么是串行

   > 一个一个的执行

6. 什么是异步？

   > 

7. 什么是同步？

   > 同步和异步的区别是是否要等待某件事情做完再去做其他事

   

扩展：

1. CAS（Compare and Swap）
2. MESI缓存一致性协议
3. <img src="../../images/Xnip2021-04-15_15-39-29.jpg" alt="Xnip2021-04-15_15-39-29" style="zoom:30%;" />