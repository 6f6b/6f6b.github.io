1. 编写Mapper接口，并添加@Mapper注解（声明该接口是一个Mapper接口）

2. 编写Mapper映射文件

3. gradle提供了gradle插件来简化依赖声明，并且可以构建可执行文件

4. Springframework

   https://docs.spring.io/spring/docs/5.2.4.RELEASE/

5. mvn dependency:tree依赖树

6. 每个Springboot版本都关联一个springframework版本，我们非常不建议你去改写关联的springframework版本

7. Spring风格的占位符`${..}`,maven风格的占位符`@..@`,You can override that by setting a Maven property called resource.delimiter

8. 当不使用spring-boot-starter-parent时，并且要特别指定某个依赖的版本的时候，该依赖放在spring-boot-dependencies前面

9. <type>pom</type>
    <scope>import</scope>这两个东西分别什么作用？

10. 如何覆盖starter里指定的版本？

11. 代码放在default package中可能导致出错，因为SpringBoot使用的一系列注解可能扫描不到，但为什么呢？看稍后的讲解

12. Using a root package also allows component scan to apply only on your project.这句话如何解读？

13. he package of the @SpringBootApplication annotated class is used to search for ...

14. You need not put all your @Configuration into a single class. The @Import annotation can be used to import additional configuration classes. Alternatively, you can use @ComponentScan to automatically pick up all Spring components, including @Configuration classes.

15. 配置类是什么？怎么写？为什么这么写？

16. You need to opt-in to auto-configuration by adding the @EnableAutoConfiguration or @SpringBootApplication annotations to one of your @Configuration classes.（只在一个配置文件中加注解即可），自动配置做了什么，没自动配置的那部分又做了什么，将何去何从，不加EnableAutoConfiguration又怎样？

17. If you need to find out what auto-configuration is currently being applied, and why, start your application with the --debug switch. Doing so enables debug logs for a selection of core loggers and logs a conditions report to the console.如何搞明白自动配置的运行原理

18. EnableAutoConfiguration注解可以通过excludeName、excludeName来设置哪些类不自动配置，spring.autoconfigure.exclude也可以设置

19. If you structure your code as suggested above (locating your application class in a root package), you can add @ComponentScan without any arguments. All of your application components ( @Component, @Service, @Repository, @Controller etc.) are automatically registered as Spring Beans.

20. the package of the @SpringBootApplication annotated class is used to search for @Entity items. 

21. **Spring Beans and Dependency Injection**?

22. If you absolutely must use XML based configuration, we recommend that you still start with a @Configuration class. You can then use an @ImportResource annotation to load XML configuration files.关于如何引入xml配置

23. @SpringBootApplication also provides aliases to customize the attributes of @EnableAutoConfiguration and @ComponentScan.如何使用？

24. It is also possible to run a packaged application with remote debugging support enabled. Doing so lets you attach a debugger to your packaged application, as shown in the following example:

    ```java
    $ java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \ -jar target/myapplication-0.0.1-SNAPSHOT.jar
    ```

25. MAVEN_OPTS、JAVA_OPTS？
26. Java hot-swapping









maven 和 gradle的区别是什么？

#### 1. Building a RESTful Web Service

1. JSON.jackson自动被包含在webstart中，JSON.jackson用来把对象转换成json

