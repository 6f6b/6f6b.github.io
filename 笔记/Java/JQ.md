1. Field 可以有多个修饰符
2. Java建议成员变量采用private修饰，通过public修饰的getter和setter方法来访问成员变量
3. 可以采用下划线来分割较长的数字
4. 方法的签名：calculateAnswer(double, int, double, double)，就是方法名字和后面的一串参数
5. 参数顺序对签名有没影响？
6. 少用方法重载，降低可读性
7. `new Bicycle(30, 0, 8)` creates space in memory for the object and initializes its fields.
8. 可变参数：methodName(ArgType... args),这里既可以传一串参数，也可以传一个数组（可变参数是否可以放在中间？）
9. Java传参时，无论是基础数据类型还是引用类型传参，都是值传递，也就是在函数内部并不能改变引用的指向
10. 