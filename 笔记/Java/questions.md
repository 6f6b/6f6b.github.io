1. 各个注解是什么意思？如何查看注解的实现方式？注解的使用方式？

2. 各个浮点类型都不能用来表示货币，那用什么表示？

3. transient修饰符

4. System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date); B是干嘛的

5. Mysql、JDBC、Druid、MyBatis之间是什么关系？

6. serialVersionUID用来干嘛的？

   > * 反序列化的时候用来做校验（怎么做校验？），用private static final long 来修饰，如果不设置这个属性则Java会根据类的具体情况计算（怎么计算？根据什么计算）出这个么一个值来进行校验，但这样不确定性因素很多，如类的内部细节、甚至编译器的不同都会有影响
   > * 数组没有这个属性，并且数组也不会进行校验（有没有引发出什么问题，如果没有这样的问题，为什么？）

7. == 和 equals的区别？

   > ```java
   > String key = null;
   > key == null;//为true
   > key.equals(null);//会崩溃，NullPointerException
   > ```
   > * equals的内部其实就是 this == xxx，即比较的事两个对象的内存地址，因为this访问了一个空对象的地址，所以造成报错
   > * 所以区别就是equals只能用来比较非空对象
   
8. Cloneable接口中为何不定义一个clone方法？为什么要在Object类中定义一个抽象的clone方法？

   > note：重写clone方法而不实现Cloneable会抛出CloneNotSupportedException异常





### 待学习的内容

1. 正则表达式
2. 

- 线程同步
- 线程间通信
- 线程死锁
- 线程控制：挂起、停止和恢复

2. 一个应用技术的几个基本条件

3. 为何不建议将版本号用于做功能兼容

4. vue创建一个初等的站点（创建->简单开发->发布）

5. Servlet是个什么东西？

6. Tomcat是什么，以及Tomcat怎么安装（Linux、MacOS）

7. mac idea不显示maven project的问题

   https://blog.csdn.net/lswandt/article/details/100213455
   
8. \#{propertyname}?

9. 注解？

   https://www.runoob.com/w3cnote/java-annotation.html

10. 注解工作原理？

   1. 通过反射或AOP实现其工作逻辑

11. gradle

    基于maven等的自动化构建工具

12. 带参数的Bean,参数是怎么传过去的？

13. 
