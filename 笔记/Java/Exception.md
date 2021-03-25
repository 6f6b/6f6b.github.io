1. 什么是异常?

   > 异常就是一个事件，一个扰乱了程序正常执行流的事件

2. 异常分类

   1. Checked Exception
   2. Error （不受约束的异常）
   3. Runtime Exception （不收约束的异常）

   > 所谓不受约束的异常是指在代码中可以不对该类型的异常进行捕获、处理

3. 异常的好处

   1. 分离正常的业务代码和异常处理代码，使得主要业务逻辑更加清晰
   2. 自行往程序调用栈的顶部传播，过程中谁感兴趣谁处理。而我们传统的处理方式是通过返回错误码来进行传播，这就使得要对每个这个调用栈中的每一个函数返回结果进行判断
   3. 因为异常是通过异常类生成的对象来表示，所以可以很方便的对异常进行分类

4. 抛出异常

   ```java
   throw new ExceptionClass() //该表达式后面的代码不再执行，类似于return
   ```

5. 捕获异常及声明异常

   1. 捕获

      ```java
      try{可能抛出异常的表达式}
      catch(Exception e){处理抛出的异常}
      finally{无论如何都会执行的代码块，可省略}
      ```

   2. 声明（方法）

      ```java
      public void writeList() throws IOException, IndexOutOfBoundsException {...}
      ```

6. 异常链

   > 可通过异常链知道ExceptionA造成了ExceptionB，ExceptionB造成ExceptionC ...

7. 自定义异常

   > 创建一个继承与超级异常类的自定义类即可，至于选择哪个超级类来继承则根据具体业务场景来定

