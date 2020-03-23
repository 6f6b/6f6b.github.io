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