# 并发相关

# Processes and Threads

A computer system normally has many active processes and threads. This is true even in systems that only have a single execution core, and thus only have one thread actually executing at any given moment. Processing time for a single core is shared among processes and threads through an OS feature called time slicing.

## Processes

A process has a self-contained execution environment. A process generally has a complete, private set of basic run-time resources; in particular, each process has its own memory space.

Processes are often seen as synonymous with programs or applications. However, what the user sees as a single application may in fact be a set of cooperating processes. To facilitate communication between processes, most operating systems support *Inter Process Communication* (IPC) resources, such as pipes and sockets. IPC is used not just for communication between processes on the same system, but processes on different systems.

## Threads

Threads are sometimes called *lightweight processes*. Both processes and threads provide an execution environment, but creating a new thread requires fewer resources than creating a new process.

Threads exist within a process — every process has at least one. Threads share the process's resources, including memory and open files. This makes for efficient, but potentially problematic, communication.

Multithreaded execution is an essential feature of the Java platform. Every application has at least one thread — or several, if you count "system" threads that do things like memory management and signal handling. But from the application programmer's point of view, you start with just one thread, called the *main thread*. This thread has the ability to create additional threads, as we'll demonstrate in the next section.





Questions：

1. 什么是多线程？
2. 什么是多进程？
3. 什么是并发？
4. 什么是异步？
5. 什么是同步？
6. 





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