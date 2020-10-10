### Spring

1. 能够描述Spring框架
   1. Spring框架的介绍
   2. Spring框架的作用
2. 能够理解Spring的IOC容器
   1. IOC？
   2. DI？
   3. IOC的底层实现原理
3. 编写SpringIOC的入门案例
   1. Spring的IOC开发需要的jar包在哪儿找？
   2. 编写Spring的配置文件
   3. 独立引入Spring的配置文件的Schema约束
   4. 独立编写相关的接口和类
   5. 独立配置类到Spring中
   6. 独立编写测试程序进行测试
4. 能够说出Spring的Bean标签的配置
   1. Bean标签中的id和name属性的作用
   2. Bean标签中的class属性的作用
   3. Bean标签中的scope属性的作用
   4. Bean标签中的init-method和destroy-method属性的作用
5. 能够理解Bean的实例化方法
   1. 说出Bean的四种实例化方式
   2. Bean的无参构造实例化单元测试
   3. Bean的静态工厂实例化单元测试
   4. Bean的实例工厂实例化单元测试
6. 能够理解Bean的属性注入方法
   1. 说出Bean的属性注入方式
   2. Bean的构造参数注入单元测试
   3. Bean的setter方法注入单元测试
7. 能够理解其他属性的注入方式
   1. 实现Bean的p名称空间的属性注入的代码
   2. 实现Bean的SpEL的属性注入代码
8. 能够理解复杂类型的属性注入





Java EE 体系结构

##### 1. Client客户端层

````
DHTML(html、JavaScript、jQuery等)
JavaApplication（Applet等）
GUI
````

##### 2. Web表现层

```
Servlet、JSP、Struts
```
##### 3. Business业务层

```
JavaBean、EJB（企业级JavaBean）
```
##### 4. EIS集成层（持久层）

```
JDBC、hibernate、Mybatis、数据库的CRUD
```



## Spring (Core Technologies) 
1. ##### Spring Overview，Spring是一个框架，这个框架有什么用？

   > 1. 使得创建企业级Java应用变得更加容易
   > 2. 支持大量的应用场景
   > 3. 拥有庞大的并活跃的社区，使得Spring能够在非常长的时间内不断演变
   > 4. The term "Spring" means different things in different contexts.

2. Spring的设计哲学

   > 1. 使你决定要使用哪个外部框架这件事尽可能靠后，并通过配置进行修改即可，而无需修改代码
   > 2. 兼容并包、灵活
   > 3. 向后兼容，每次升级只进行小的改动
   > 4. 花费大量时间进行小心的设计api
   > 5. 高质量代码

3. ##### 容器

   > 1. 容器用到的配置元数据
   > 2. 容器的实例化
   > 3. 容器的使用

4. The `org.springframework.context.ApplicationContext` interface represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the beans. The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata. The configuration metadata is represented in XML, Java annotations, or Java code. It lets you express the objects that compose your application and the rich interdependencies between those objects.

   > ApplicationContext就代表Spring的IOC容器，它负责对bean进行实例化、配置、组装，那么怎么进行实例化、配置、组装呢？这就通过读取配置元数据来进行指导，配置元数据通过xml、Java注解、Java代码来进行表现。

5. xml已作为一种传统的旧的提供元数据的格式，提供少量的xml文件来声明使用注解或者Java代码作为配置元数据格式

   > 也就是说你如果要使用Java注解或Java代码来作为配置元数据格式的话，必须还得通过xml声明了才得行

6. local file system 和 Java的CLASSPATH的区别是什么？

   > 两个都是path，也就是说两个都是指路径，只不过这两个路径的值不一样？？

7. @Bean通常作用在一个被@Configuration注解的类的方法上（这样的类称为配置类）

8. AspectJ

   > 可理解为Java演化出来的一个新的语言，用于进行AOP开发

9. it is better form not to use the slash at all 定义资源路径的时候前面最好不加斜杠

10. ##### Bean

   > 1. bean的名字
   > 2.  实例化
   >    1. 构造函数
   >    2. 静态工厂方法
   >    3. 实例工厂方法

11. Bean Overview

    > 在容器中，那些bean的定义(通过xml、Annotation、Javacode)表现为一个个的BeanDefinition对象，这些对象包含(不限于)以下信息
    >
    > 1. bean的完整类名
    > 2. bean的行为(域、生命周期、回调 ...)配置元素
    > 3. 对其他bean的引用
    
9. You can autowire strongly-typed `Map` instances if the expected key type is `String`，强类型的map实例是什么意思？为什么要期望的key type是string才行，其他类型的key不行吗？map除了string作为key，还有其他什么类型可以作为key吗？

   > ?

10. Bean的个性化定制

    > 1. bean的声明周期回调
    >    1. 初始化
    >    2. 销毁

12. ##### Dependency Injection

    > 依赖注入是一个处理过程，这个过程就是容器给bean注入依赖，那么他怎么注入呢？根据什么来注入呢？答案是根据构造函数中的参数、工厂方法中的参数、实例化后设置的bean的属性

15. scope

    > [scope文档](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-scopes-singleton)
    >
    > * scope为prototype 时，该bean的销毁方法不会被执行！
    > * 通过构造方法和setter方法注入依赖，这样的依赖解析只会执行一次
    > * web容器中存在额外的四种scope，request、session、application、websock，那么这四种scope对应的四种process的生命周期是怎样的？

16. 我们可以通过实现BeanPostProcessor来实现对Bean的初始化、依赖解析逻辑、等进行自定义，其具体操作就是你搞一个类A实现BeanPostProcessor这个协议里面的方法，并将这个类A搞成ApplicationContext容器中的一个Bean，那么当其他类要进行初始化的时候，你在A对应的Bean里面就能收到相应的回调了

    > 注意：当通过@Bean修饰的工厂方法来获得一个实现了BeanPostProcessor的Bean的时候，其返回类型需要是这个实现类本身或者BeanPostProcessor，这样容器才能尽可能早的将这个bean注册为post-processor（他确实需要尽可能早，不然那其他bean初始化的时候，如果这个post-processor bean都还没创建，那process又从何谈起呢）

17. The `PropertySourcesPlaceholderConfigurer` not only looks for properties in the `Properties` file you specify. By default, if it cannot find a property in the specified properties files, it checks against Spring `Environment` properties and regular Java `System` properties.

    >  it checks against Spring `Environment` properties and regular Java `System` properties.这句话中的**Spring `Environment` properties**和** Java `System` properties**

18.  Annotation injection is performed before XML injection. Thus, the XML configuration overrides the annotations for properties wired through both approaches.

    > 通过xml配置的数据会覆盖通过注解配置的数据

19. 关于注解配置与xml配置的争论

    > 注解的好处：由于注解的声明提供了大量的上下文，因此我们使用的注解就变得短小、精简（其声明提供了关于注解足够的信息）
    >
    > xml的好处：xml配置则不需要接触源码，并且不需要对源代码进行重新编译
    >
    > 争论认为注解将对象变成了非POJOs并使得配置数据变得分散和难以控制
    >
    > 对于我自己而言，我更倾向于使用注解，因为对他更亲近使用起来更熟练

20. An alternative to XML setup is provided by annotation-based configuration, which relies on the bytecode metadata for wiring up components instead of angle-bracket declarations

    > 从这句话中我们可以看出，通过注解进行配置其根本原理是通过字节码数据来进行模块的组装，
    >
    > 而xml则是通过识别尖括号

21. BeanPostProcessor的example

    > 比如这个RequiredAnnotationBeanPostProcessor，它是BeanPostProcessor的实现类之一，是由Spring提供的，它主要就是负责检查Bean的带有@Required注解的属性是否被设置值了

22. 通过注解来进行Bean的配置其实现原理

    > 说白了就是通过BeanPostProcessor的实现来进行的，Spring2.0实现了通过RequiredAnnotationBeanPostProcessor来进行@Required注解的识别，Spring2.5的时候以相同的方式又新增了@Autowire的识别，但其具备了更加细颗粒度的控制和更广的适用范围
    >
    > 注：Spring5.1的时候废弃了@Required注解，建议通过构造方法注入必须的属性值

23. CGLIB proxies intercept only public method calls! Do not call non-public methods on such a proxy.

24. You can autowire strongly-typed `Map` instances if the expected key type is `String`，强类型的map实例是什么意思？为什么要期望的key type是string才行，其他类型的key不行吗？map除了string作为key，还有其他什么类型可以作为key吗？

25. 依赖注入原理、依赖注入目的

    > 原理：通过解析配置元数据来动态的生成相应的实例
    >
    > 目的：使用依赖由主动变被动，形成一种松散耦合结构

26. 如何在IDEA中搜索maven库？

27. Autowire

    > Autowire本质上是通过类型匹配对bean进行筛选，进而进行依赖注入
    >
    > 有两个可以对Autowire的机制进行微调的注解：`@Primary`、`@Qualifiers`
    >
    > `@Primary`:这个东西就是说当@Autowire匹配到多个bean时，优先使用用了@Primary注解的那个Bean
    >
    > `@Qualifiers`:可以理解成标签，用在Bean上表示这个Bean有哪些标签，用在注入点时表示这里需要哪些标签的Bean
    >
    > `@Autowired` applies to **fields, constructors, and multi-argument methods**, allowing for narrowing through qualifier annotations at the parameter level. In contrast, `@Resource` is supported only for **fields and bean property setter methods with a single argument**. As a consequence, you should stick with qualifiers if your injection target is a constructor or a multi-argument method.
    >
    > 如果需要完全通过Bean的名字来进行依赖注入，使用@Resource

28. ##### Bean 的生命周期跟踪

    > 1. 在Bean的类的方法上面加注解@PostConstruct/@PreDestroy
    > 2. 实现InitializingBean/DisposableBean这两个接口
    > 3. 通过@Bean指定相关的方法

29. 当将上面三个机制结合起来用的时候执行顺序是怎样的

    > 同上面的顺序

30. 当三个机制指向一个方法的时候这个方法会执行几次？

    > 1次

31. 如何在IDEA中搜索maven库？

32. 我们通过插入（怎么插入）一些实现的特殊的集成(集成接口怎么理解？)接口来对IOC Container进行扩展，这些接口如BeanPostProcessor，我可以配置多个BeanPostProcessor实例，并且可以通过order来控制这些实例被执行的顺序，问题是我怎么配置这多个实例？如果我不设置order，那么它的默认order是什么？设置order的动机可能是什么？

> 这些实例的配置方式跟普通的bean是一样的配置方式
>
> 默认order不知道
>
> 设置order的动机：比如要搞一个Chain of Resolvers

32. 扩展Container的目的是什么？解决什么问题？
33. 实例化instantiating和初始化initialization的区别是什么？
34. container hierarchies.是什么意思？怎么理解container的hierarchy？
35. BeanPostProcessor用来对Bean实例进行处理
36. BeanFactoryPostProcessor则用来对Bean的definition进行处理



A bean post-processor typically checks for callback interfaces 这句话怎么理解

or it may wrap a bean with a proxy. Some Spring AOP infrastructure classes are implemented as bean post-processors in order to provide proxy-wrapping logic. 这句话又怎么理解？



容器会自动检测配置元素中定义的那些实现了BeanPostProcessor接口的Bean，并且将他们注册为后处理器

如果是通过@Bean来搞一个后处理器进去，那么这个工厂方法的返回类型必须是这个bean的真正类型或者是BeanPostProcessor类型，否则容器cannot autodetect it by type before fully creating it，即无法通过类型来尽可能早的侦测到并实例化它，但它确实需要被先实例化，以保证实例化其他bean的时候执行它的回调。

至此，我们看到了两种注册后处理器的方法

1. xml
2. @Bean

除了上面两种方式，我们还可以通过ConfigurableBeanFactory执行addBeanPostProcessor放来注册后处理器，用这个方法的主要动机是我们可以在这个接口中去做一些条件判断或者在同一层级的容器之间对后处理器进行拷贝，那么这个接口具体是怎么使用的呢？

并且，如果通过ConfigurableBeanFactory来注册后处理器的话，那么这些处理器的order就没有用了，这些处理器的执行顺序将完全由它们的注册顺序决定，需要注意的是一般情况下通过ConfigurableBeanFactory注册的后处理器都先于那些通过自动侦测注册的处理器执行，无论这些通过自动侦测注册的处理器显式设置的order是多少



AOP auto-proxying是个什么东西？

Because AOP auto-proxying is implemented as a BeanPostProcessor itself 怎么理解？

While it is technically possible to work with bean instances within a `BeanFactoryPostProcessor` (for example, by using `BeanFactory.getBean()`) BeanFactory是什么？

Bean(Factory)PostProcessor 设置懒加载是没有效的，因为没有懒加载的使用场景，如果你要用这两个东西，那必定是要尽可能早的初始化他们

当使用BeanFactoryPostProcessor的实现类如BeanPropertySourcePlaceholderConfigure来外部化bean的属性的时候，如果定义了多个properties文件，并且有多个相同的key时，占位符使用谁的值呢？

> ​	In case of multiple `PropertyOverrideConfigurer` instances that define different values for the same bean property, the last one wins, due to the overriding mechanism.这可以解答上面的问题，但是新的问题又来了，the last one wins，who is the last？

`context` namespace是个什么东西？它与<context:property-placeholder location="classpath:com/something/jdbc.properties"/> 有什么关联？

it checks against Spring `Environment` properties and regular Java `System` properties.这里的Spring `Environment` properties指什么，在哪里可以看到？同问Java `System` properties

If an overriding `Properties` file does not have an entry for a certain bean property,



基于xml的容器配置和基于注解的容器配置孰优孰劣？

简单地说：看情况

详细的说：各有各的好处、各有各的缺点

注解：

1. 由于注解在其定义中提供了大量的上下文，使得用注解进行配置时更加简短和精炼

Xml:

1. 优点在于可以在不用接触源码或重新编译的源码的情况下连接组件



 It is worth pointing out that through its [JavaConfig](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-java) option, Spring lets annotations be used in a non-invasive way,without touching the target components source code and that通过JavaConfig可以以一种非侵入性的方式使用注解，怎么实现的？侵入性是什么？有什么危害？



 JSR-250 annotations是什么？

if you put `<context:annotation-config/>` in a `WebApplicationContext` for a `DispatcherServlet`,怎么理解？

WebApplicationContext 和 DispatcherServlet的关系


Bean definitions in one container ，多个container怎么体现？一个bean定义在一个container中怎么体现



@Autowire用在一般方法上表示什么意思？容器自动调用吗？

@Priority注解不能用在方法上，他要表达的语义可以通过@Order和@Primary的结合来表达，那么@Priority究竟表达的是什么语义呢？@Order和@Primary又分别表达什么语义呢？

当有多个构造函数的时候，容器解析算法是怎么样的？（即怎么决定使用哪一个构造函数）



对于@Autowire在构造函数和工厂函数上的应用，我的理解是这样的：默认情况下单个或多个构造函数都是需要具备参数所需的bean，否则将返回一个空的实例，当加上@Autowire注解后，多个构造函数的情况仍然不变（基于容器的解析算法导致），而单个构造函数的情况下某些参数的bean匹配不上时，构造函数仍然可以成功调用



Consider factoring out the affected methods to a separate delegate bean in such a scenario. Alternatively, you can use `@Resource`, which may obtain a proxy back to the current bean by its unique name.怎么理解？



@Autowire与@Qualifire的结合使用，结合场景？

the automatic translation of exceptions？



给自动检测的组件进行命名，默认的命名策略是什么？如何自定义命名？为什么要自定义命名？

> 对于Stereotype Annotation修饰的组件，可以使用这些注解的value来进行命名，若没有对其命名，则策略为使用首字母小写的类名来进行命名（若不同包中有相同类名时怎么命名？），因为想，所以自定义命名。



 When working with this mode in your IDE, the `spring-context-indexer` must be registered as an annotation processor to make sure the index is up-to-date when candidate components are updated.

must be registered as an annotation processor如何理解？这个annotation processor 如何确保index是最新的？这个annotation processor 如何生成index？

 The index is enabled automatically when a `META-INF/spring.components` is found on the classpath. If an index is partially available for some libraries (or use cases) but could not be built for the whole application怎么理解？



injection point ，什么是Injection point?



什么是lite @Bean method？

> 当@Bean method位于一个没有被@Configuration缩注释的类中时，这个method就叫lite @Bean method

 inter-bean dependencies.是什么？



lite `@Bean` methods cannot declare inter-bean dependencies，什么是inter-bean dependencies

Each such method is literally only a factory method for a particular bean reference(这里的particular bean reference是否指的就是该方法返回的实例？), without any special runtime semantics（怎么理解？）. The positive side-effect here is that **no CGLIB subclassing has to be applied at runtime**（粗体是什么意思？为什么它就是积极的了？）, so there are no limitations in terms of class design（为什么这样就没有limitation？如果有，limitation是什么？） (that is, the containing class may be `final` and so forth 这跟前面的语句有什么关联？).



In common scenarios, `@Bean` methods are to be declared within `@Configuration` classes, ensuring that “full” mode is always used and that cross-method references therefore get redirected to the container’s lifecycle management. This prevents the same `@Bean` method from accidentally being invoked through a regular Java call, which helps to reduce subtle bugs that can be hard to track down when operating in “lite” mode.

1. 什么是full model？
2.  cross-method references是什么？是@Bean方法中调用了其他@Bean方法吗？
3. 为什么在full model下cross-method references就会重定向到容器的生命周期管理中？这里的重定向又是具体指什么？
4. the same @Bean method是什么意思？
5. 阻止了he same @Bean method通过正常的Java调用，为什么要阻止？怎么阻止的？
6.  reduce subtle bugs，为什么在 lite model下就会产生subtle bugs？



依文档来看，当@Bean的返回类型不够完全的时候，匹配结果取决于匹配的时候该Bean实例是否已经实例化了，

这是全类型匹配不完全类型的情况，那么当一个不全类型匹配全类型又是怎么样一种流程呢？



 If you consistently refer to your types by a declared service interface, your `@Bean` return types may safely join that design decision（怎么理解这句话？）. However, for components that implement several interfaces or for components potentially referred to by their implementation type, it is safer to declare the most specific return type possible (at least as specific as required by the injection points that refer to your bean)



 If a `@Configuration` class is marked with `@Profile`, all of the `@Bean` methods and `@Import` annotations associated with that class are bypassed unless one or more of the specified profiles are active.怎么active one or more Profiles？active more profiles会不会有问题？



当一个配置类中有多个方法名相同的重载方法时，这些方法上的@Profile中的condition需要是一致的，如果不一致的话only the condition on the first declaration among the overloaded methods matters.？如果一致的话，使用哪个方法按照spring的解析算法来决定



 The `@PropertySource` annotation is repeatable, according to Java 8 conventions. However, all such `@PropertySource` annotations need to be declared at the same level（same level是指？）, either directly on the configuration class or as meta-annotations within the same custom annotation. Mixing direct annotations and meta-annotations is not recommended, since direct annotations effectively override meta-annotations.



In particular, make sure to always do it for a `DataSource`, as it is known to be problematic on Java EE application servers.这里的do it是指@Bean(destroyMethod="")，这里的problematic是指什么？



scoped-proxy

As noted earlier, [lookup method injection](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-method-injection) is an advanced feature that you should use rarely. It is useful in cases where a singleton-scoped bean has a dependency on a prototype-scoped bean，为什么





Make sure that the dependencies you inject that way are of the simplest kind only. `@Configuration` classes are processed quite early during the initialization of the context, and forcing a dependency to be injected this way may lead to unexpected early initialization. Whenever possible, resort to parameter-based injection, as in the preceding example.

Also, be particularly careful with `BeanPostProcessor` and `BeanFactoryPostProcessor` definitions through `@Bean`. Those should usually be declared as `static @Bean` methods, not triggering the instantiation of their containing configuration class. Otherwise, `@Autowired` and `@Value` may not work on the configuration class itself, since it is possible to create it as a bean instance earlier than [`AutowiredAnnotationBeanPostProcessor`](https://docs.spring.io/spring-framework/docs/5.2.7.RELEASE/javadoc-api/org/springframework/beans/factory/annotation/AutowiredAnnotationBeanPostProcessor.html).



property-placeholder 在xml和Annotation中的使用方式？

Spring also provides the `HierarchicalMessageSource` interface, which can resolve messages hierarchically.（最后一句怎么理解？）

The example assumes that you have three resource bundles called `format`, `exceptions` and `windows` defined in your classpath.resource bundles是什么？classpath是什么？



The event type can also be narrowed through generics as long as the actual event type resolves your generic parameter in its implementation hierarchy.



RAR deployment is a more natural alternative to a scenario of deploying a headless WAR file 为什么说rar是一种更自然的方案？为什么说war file是headless



Application-level beans may use the same callback interfaces but typically prefer declarative dependency injection instead, either through annotations or through programmatic configuration.（Application-level beans是指什么样的bean？还有其他level的bean吗？）



 Within an `ApplicationContext` (such as the `GenericApplicationContext` implementation), several kinds of beans are detected by convention (that is, by bean name or by bean type — in particular, post-processors), while a plain `DefaultListableBeanFactory` is agnostic about any special beans.最后这一句话是什么意思？



core container的all common purposes:

1. loading of configuration files
2.  triggering a classpath scan
3. programmatically registering bean definitions and annotated classes
4.  (as of 5.0) registering functional bean definitions.



为什么单独使用DefaultListableBeanFactory时post-processors默认不会被侦测和激活？其他bean是否也是这样？

ServletContext

a Spring IoC container ultimately uses standard JavaBeans `PropertyEditor` implementations to convert these strings to the complex type of the property怎么决定选用哪一个PropertyEditor实现来进行转换



There are pros and cons for considering validation as business logic（为什么有优点又有缺点？优点是什么？缺点是什么？）, and Spring offers a design for validation (and data binding) that does not exclude either one of them. Specifically, validation should not be tied to the web tier （为什么？）and should be easy to localize, and it should be possible to plug in any available validator. Considering these concerns, Spring provides a `Validator` contract that is both basic and eminently usable in every layer of an application.（一个application 分为哪些层？怎么体现的？）



依赖注入带来的好处：

1. 使得代码更加的干净
2. 有效解耦（不需要查找依赖或者关注依赖从何而来）
3. 更加容易进行单元测试




如果学了一大半完全从头来过也是一件比较恼火的事，很打击人，但如果不重头再来一遍则难以加深理解，并且容易忘记，而且不利于后续内容的学习。所以最好的方式还是在学的过程中做好以下几点

1. 尽可能能的深入理解看到的内容
2. 梳理脉络，进行总结、做笔记
3. 看了一小部分后回头来回顾以下



有些东西能够容易的被理解，但是要怎么的去持久的记住它呢？

能够保持长时间的专注是一种非常难得和宝贵的能力！



## Spring-Boot

1. Auto-configuration

   > 自动配置的机制:根据开发者添加的依赖包来决定需要自动配置哪些bean
   >
   > 有几个问题：
   >
   > 1. 它会自动给我配置什么bean？
   >
   >    > 调试模式下进行查看
   >
   > 2. 如何禁止某个自动配置类？
   >
   >    > (exclude={DataSourceAutoConfiguration.class})
   >
   > 3. 如何替换自动配置的bean？
   >
   >    > 定义好你想配置的bean就行了

2. Lazy Initialization

   > 懒加载的好处应该是可以减少启动时间
   >
   > 缺点：
   >
   > 1. 问题不能提早暴露，比如某些bean缺失
   > 2. jvm 空间不够，只足够启动期间初始化的那些bean

3. Externalized Configuration

   > 有什么好处：
   >
   > 1. 一个相同的应用程序可以运行在不同的环境下
   >
   > 有哪些方式：
   >
   > 1. property files
   > 2. yaml
   > 3. 环境变量
   > 4. 命令行参数

4. Log files rotate when they reach 10 MB and, as with console output, `ERROR`-level, `WARN`-level, and `INFO`-level messages are logged by default. Size limits can be changed using the `logging.file.max-size` property. Rotated log files of the last 7 days are kept by default unless the `logging.file.max-history` property has been set. The total size of log archives can be capped using `logging.file.total-size-cap`. When the total size of log archives exceeds that threshold, backups will be deleted.

   > 默认情况下
   >
   > * 日志文件达到10MB开始新建日志文件记录
   > * 存储过去7天的日志

5. ORM是什么？

   > Object Relational Mapping，这是一个技术，它叫做对象关系映射，如果某个技术实现了两个不同类型的对象的转换，我们称这个技术为ORM技术

6. JDBC、JPA、Spring Data JPA、Hibernate、Mybatis、MySQL、Oracle、之间的关系和区别

   > * JDBC和JPA都属于规范和接口，不同的是JDBC是面向SQL的，就是说Java开发人员通过调用JDBC提供的接口执行SQL语句来操作数据库；通过SQL直接操作数据库是很繁琐的，因此我们希望通过操作对象的形式来操作数据库，那就需要有一个框架能够把相应的对象转换为相应的SQL并交给JDBC来执行，因为这个框架实现了不同类型数据之间的转换，因此这些框架叫做ORM框架，这些框架内部到底怎么转换为SQL不需要关心，但是提供给开发人员使用的接口需要有一个规范以保证开发人员能够轻松的替换不同的框架，这个规范就叫JPA。
   >* Hibernate属于遵循JAP规范的ORM框架
   > * 和Spring Data JPA是通过定义接口就可以操作数据库，接口的实现由Spring完成（说实话，Hibernate和这个东西的关系还是有点懵）
   > * MyBatis？？
   > * MySQL和Oracle是一个数据库软件，如果让这些软件执行SQL语句便能对数据库中的数据进行操作
   >
   > Java应用->遵循JPA规范的ORM框架->JDBC->数据库软件
   >
   > 参考：https://www.cnblogs.com/yunche/p/10279324.html

7. The [Spring Framework](https://spring.io/projects/spring-framework) provides extensive support for working with SQL databases, from direct JDBC access using `JdbcTemplate` to complete “object relational mapping” technologies such as Hibernate. [Spring Data](https://spring.io/projects/spring-data) provides an additional level of functionality: creating `Repository` implementations directly from interfaces and using conventions to generate queries from your method names.

   > Java提供了JDBC来让我们操作SQL数据库，后面又衍生出了ORM技术产品如Hibernate来操作数据库，而Spring更牛逼了，他提供的SpringData使得我们只需要定义接口就完了，其实现会在运行时产生

8. HATEOAS 与 RESTful？

9. 缓存可能存在的问题以及解决方案

   > 1. 从业务的角度来看，相同的入参可能会出现不同的结果，缓存技术该如何满足这一需求？
   >
   > 2. 多节点部署的情况下如何实现缓存同步？
   >
   > 3. 如果多个线程并发的更新或清理缓存，则可能导致取到过时的数据，如何处理这种问题？
   >
   >    > 相应的缓存实现中提供了高级功能来解决这个问题（具体解决思路是怎样的？）
















### TODO:

java基础：

1. 线程
2. 反射
3. map
4. 泛型
5. lambda表达式

spring相关：

1. IOC（DI）☆
2. AOP ☆
3. maven
4. 数据库
5. 分布式事务
6. gradle
7. 中间件
8. 分布式缓存
9. 消息
10. Auth2.0
11. 非关系型数据库NoSQL
















