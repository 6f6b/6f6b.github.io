1. Field 可以有多个修饰符

2. Java建议成员变量采用private修饰，通过public修饰的getter和setter方法来访问成员变量

3. 可以采用下划线来分割较长的数字

4. 方法的签名：calculateAnswer(double, int, double, double)，就是方法名字和后面的一串参数

5. 参数顺序对签名有没影响？

6. 少用方法重载，降低可读性

7. `new Bicycle(30, 0, 8)` creates space in memory for the object and initializes its fields.

8. 可变参数：methodName(ArgType... args),这里既可以传一串参数，也可以传一个数组（可变参数是否可以放在中间？）

9. Java传参时，无论是基础数据类型还是引用类型传参，都是值传递，也就是在函数内部并不能改变引用的指向

10. 系统如何回收使用完的对象

    An object is **eligible** for garbage collection when there are no more references to that object. References that are held in a variable are usually dropped when the variable goes out of scope. Or, you can explicitly drop an object reference by setting the variable to the special value `null`. Remember that a program can have multiple references to the same object; all references to an object must be dropped before the object is eligible for garbage collection.

    The Java runtime environment has a garbage collector that **periodically** frees the memory used by objects that are no longer referenced. The garbage collector does its job automatically when it determines that the time is right. 

11. 如果函数的参数名跟成员变量名相同，参数名会覆盖成员变量名，所以得使用this

12. 在构造函数中可以使用this去访问其他的构造函数（If present, the invocation of another constructor must be the first line in the constructor.）

13. access control：（**防止误用导致发生错误**）

    * 对于类而言
      * public，随处可用
      * default/package-private，在整个包内都可以访问
    * 对于成员变量而言
      * public，随处可用
      * protected，包中可以访问，其他包中的子类也可以访问
      * default/package-private ，
      * private，仅在自己类中可以调用

| Modifier    | Class | Package | Subclass | World |
| ----------- | ----- | ------- | -------- | ----- |
| `public`    | Y     | Y       | Y        | Y     |
| `protected` | Y     | Y       | Y        | N     |
| no modifier | Y     | Y       | N        | N     |
| `private`   | Y     | N       | N        | N     |

- Use the most restrictive access level that makes sense for a particular member. Use `private` unless you have a good reason not to.
- Avoid `public` fields except for constants.Public fields tend to link you to a particular implementation and limit your flexibility in changing your code.

14. **Note:** You can also refer to static fields with an object reference like

    ```
    myBike.numberOfBicycles
    ```

    but this is discouraged because it does not make it clear that they are class variables.

15. 实例函数可以直接访问静态变量和静态方法，反之不能。

16. 定义一个常量 static final type filedname

17. **Note:** If a primitive type or a string is defined as a constant and the value is known at compile time, the compiler replaces the constant name everywhere in the code with its value. This is called a *compile-time constant*. If the value of the constant in the outside world changes (for example, if it is legislated that pi actually should be 3.975), you will need to recompile any classes that use this constant to get the current value.（编译时常量、基础数据类型）

18. **Note:** It is not necessary to declare fields at the beginning of the class definition, although this is the most common practice. It is only necessary that they be declared and initialized before they are used.

19. the Java programming language includes *static initialization blocks*.（how to？）

20. 可以在类中的任意位置定义一个静态代码块,静态代码块在源代码中的位置决定了执行顺序，这一点由运行时系统来保证，静态代码块可以用来初始化静态变量，同样也可以使用静态方法，并且静态方法可以被重复调用以赋予静态变量新的值

    ```java
    static {
        // whatever code is needed for initialization goes here
    }
    ```

21. 类似于静态代码块，代码块可以用来给成员变量进行初始化，它自动被编译器放进构造方法中，所以他是可以被重用的，或者通过final修饰的函数来进行成员变量初始化，The method is final because calling non-final methods during instance initialization can cause problems.

    ```java
    {
        // whatever code is needed for initialization goes here
    }
    ```

    22. This technique, called *covariant return type*, means that the return type is allowed to vary in the same direction as the subclass.（协变返回类型）

    23. **静态内部类、内部类、局部类**

    24. because an inner class is associated with an instance, it cannot define any static members itself.

    25. 一般内嵌类的实例只有在外部类实例化后，通过外部类的实例来实例化内部类，如下

        ```java
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        ```

    26. 当内嵌类的成员变量或者方法和外部类同名时，在内部类中单纯的使用同名名字来访问变量会导致覆盖（即访问的是内部成员变量），若要访问外部类的成员变量，方法如下

        ```java
        OutClass.this.fildName
        ```

    27. To handle user interface events, you must know how to use inner classes, because the event-handling mechanism makes extensive use of them.(事件处理机制广泛的用到了inner class)

    28. 位于代码块内部，有名字的类为局部类，没有名字的类叫匿名类

    29. 局部类可以访问其外部类的成员变量

    30. 在Javase8以后，局部类可以访问其所在代码块的参数以及局部变量，前提是参数和局部变量都是被final修饰的，或者是effectively final的，因为捕获？怎么讲？

    31. 类似内部类，局部类也不能定义任何的静态成员，如果一个局部类位于外部类的静态方法中，那么这个局部类中只能访问外部类的静态成员

    32. 因为局部类有访问实例变量的权利，所以他就没法被定成静态的了

    33. interface天生静态，所以不能在方法中定义interface

    34. 当局部类其成员为*constant variable*的时候，其成员可以使静态的

    35. A *constant variable* is a variable of primitive type or type `String` that is declared final and initialized with a compile-time constant expression. A compile-time constant expression is typically a string or an arithmetic expression that can be evaluated at compile time.

    36. **匿名类**

    37. he anonymous class expression consists of the following:

        - The `new` operator
        - The name of an interface to implement or a class to extend. In this example, the anonymous class is implementing the interface `HelloWorld`.
        - Parentheses that contain the arguments to a constructor, just like a normal class instance creation expression. **Note**: When you implement an interface, there is no constructor, so you use an empty pair of parentheses, as in this example.
        - A body, which is a class declaration body. More specifically, in the body, method declarations are allowed but statements are not.

    38. However, you cannot declare constructors in an anonymous class.局部类中呢？

    39. 匿名类适用于：1-方法中仅有一个类，2-有多个函数实现（只有一个函数实现可以用lambda表达式替代）

    40. 匿名类中不能定义构造方法，那么内部类和局部类呢？->可以定义

##### nested class

* nested class
  * static nested class
    * 能否访问外部类的非静态成员-no
    * 能否访问外部类的静态成员-yes
    * 外部类能否访问其静态成员-yes
    * 外部类能否访问其非静态成员-yes
    * 何时用这个类（同实例变量与静态变量的区别）
  * non-static nested class（inner class）
    * 能否访问外部类的非静态成员-yes
    * 能否访问外部类的静态成员-yes
    * 外部类能否访问其静态成员-(inner class 中不能定义静态成员)
    * 外部类能否访问其非静态成员-yes
    * 何时用这个类（在外部类中全局使用时用这个，只在某个方法中使用时用local class，只在某个方法中使用一次时用anonymous class）
  * local class
    * 类似于inner class，不同点是他的内部可以定义static 常量
  * anonymous class
    * 匿名类中不能定义构造方法

1. why use nested class
   - **It is a way of logically grouping classes that are only used in one place**
   - **It increases encapsulation**
   - **It can lead to more readable and maintainable code**:
2. 关于内部类的序列化？https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
3. 局部类跟inner class 一样不能定义静态成员，局部类位于静态方法时，只能访问外部类的静态成员

##### lambda表达式

1. 说到底，lambda表达式就是一个函数（样子已经给你定好了，怎么实现你来定）
2. 泛型的作用，约束几个值的类型统一性，但不对值具体是什么类型做约束
3. 跟local class 和 anonymous class 不同的是，lambda表达式没有新开一个域，所以不存在值覆盖的问题。
4. For method arguments, the Java compiler determines the target type with two other language features: overload resolution（重载解析） and type argument inference（类型参数推断）.

##### method reference

1. 避免同样的操作内容多次编写

##### Enum

1. Java中的枚举是一个类，隐式的继承于java.lang.Enum
2. Java中的枚举可以定义方法
3. 当枚举类中含有filed或者方法的时候，枚举列表结束时需要以分号结尾
4. The constructor for an enum type must be package-private or private access. It automatically creates the constants that are defined at the beginning of the enum body. You cannot invoke an enum constructor yourself.



1. final关键字对于方法而言，标志这个方法不能被重写；对于类而言，标志这个类不能被继承
2. 一般来讲，被构造方法调用的方法我们都建议用final修饰，以避免在子类中修改后导致出错
3. 一个抽象类中可能包含抽象方法，也可能包含非抽象方法，抽象类不能被实例化，但是可以被继承（一个包含抽象方法的类一定是抽象类）



##### 泛型

1. 泛型增加代码稳定性，如何增加？（making more of your bugs detectable at compile time）

2. 为什么要使用泛型

   1. Stronger type checks at compile time.（具体如何进行的？）

   2. 消除类型转换

      ```java
      The following code snippet without generics requires casting:
      List list = new ArrayList();
      list.add("hello");
      String s = (String) list.get(0);
      When re-written to use generics, the code does not require casting:
      List<String> list = new ArrayList<String>();
      list.add("hello");
      String s = list.get(0);   // no cast
      ```

   3. 实现通用算法



额外的学习内容

https://docs.oracle.com/javase/tutorial/extra/





