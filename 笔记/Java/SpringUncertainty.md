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



CRM系统：customer relationship manager 客户关系管理系统



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

You can autowire strongly-typed `Map` instances if the expected key type is `String`，强类型的map实例是什么意思？为什么要期望的key type是string才行，其他类型的key不行吗？map除了string作为key，还有其他什么类型可以作为key吗？



xml已作为一种传统的旧的提供元数据的格式，提供少量的xml文件来声明使用注解或者Java代码作为配置元数据格式



@Bean通常作用在一个被@Configuration注解的类的方法上（这样的类称为配置类）

Service Layers、Data Access Objects(DAO)、presentation Objects

Hibernate、SessionFactories、JMS `Queues`

AspectJ

it is better form not to use the slash at all 定义资源路径的时候前面最好不加斜杠

##### Groovy

Bean实例化的时候提供参数、以及设置属性的机制需要查看依赖注入

依赖注入原理、依赖注入目的



我们通过插入（怎么插入）一些实现的特殊的集成(集成接口怎么理解？)接口来对IOC Container进行扩展，这些接口如BeanPostProcessor

我可以配置多个BeanPostProcessor实例，并且可以通过order来控制这些实例被执行的顺序，问题是我怎么配置这多个实例？如果我不设置order，那么它的默认order是什么？设置order的动机可能是什么？

扩展Container的目的是什么？解决什么问题？

实例化instantiating和初始化initialization的区别是什么？

container hierarchies.是什么意思？怎么理解container的hierarchy？



BeanPostProcessor用来对Bean实例进行处理

BeanFactoryPostProcessor则用来对Bean的definition进行处理



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





有些东西能够容易的被理解，但是要怎么的去持久的记住它呢？





