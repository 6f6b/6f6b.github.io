## 一、SpringBoot简介

###1.概述

Spring Boot是由Pivotal团队提供的全新框架，**其设计目的是用来简化新Spring应用的初始搭建以及开发过程**。约定大于配置？

官网：https://spring.io/projects/spring-boot

###2.特点

1. 可以创建独立的**Spring**应用程序（并且基于其Maven或Gradle插件，可以创建可执行的JARs和WARs）
2. 内嵌Tomcat或Jetty等Servlet容器；
3. 提供自动配置的“starter”项目对象模型（POMS）**以简化[Maven](https://baike.baidu.com/item/Maven/6094909)配置**；
4. 尽可能自动配置Spring容器(通过注解进行自动配置)；
5. 提供准备好的特性，如指标、健康检查和外部化配置；
6. 绝对没有代码生成，不需要XML配置。

### 3.环境要求

- A favorite text editor or IDE
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
- [Gradle 4+](http://www.gradle.org/downloads) or [Maven 3.2+](https://maven.apache.org/download.cgi)
- You can also import the code straight into your IDE:
  - [Spring Tool Suite (STS)](https://spring.io/guides/gs/sts)
  - [IntelliJ IDEA](https://spring.io/guides/gs/intellij-idea/)

### 4.创建一个入门案例

通过Springboot创建一个restful风格的一个web service

> 1.创建maven工程

> 2.pom.xml中进行相关配置

```
<!--    工程的唯一标识-->
<groupId>org.example</groupId>
<!--    项目名称-->
<artifactId>SpringBootHelloWorld</artifactId>
<!--    版本号-->
<version>1.0-SNAPSHOT</version>

<!--指定打包方式 jar-->（SpringBoot和maven是个什么关系？）
<packaging>jar</packaging>

<!--配置父工程    -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.2.1.RELEASE</version>
</parent>

<!--配置依赖-->
<dependencies>
	//web启动器依赖
	<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
	</dependency>
</dependencies>

//配置了父工程和依赖后，idea会自动加载相关的文件
<!--配置插件-->
```

> 3.创建Controller编写处理器

```java
//@Controller注解声明UserController类是一个处理器类
@Controller 
public class UserController {
    @RequestMapping("sayHello")
    @ResponseBody
    public String sayHello(){
        return "Hello world";
    }
}
```



> 4.创建SpringBoot主程序类

```java
//SpringBootApplication注解声明MySpringBootApplication为SpringBoot主程序类，表示SpringBoot应用就从这儿启动，只需要之行主程序类的main方法就可以
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class,args);
    }
}
```

> 5.在resources目录下创建application.properties文件，在里面进行应用的一些属性的配置，比如端口、静态资源缓存等等

项目名或者工程路径里面最好不要有中文

maven工程中的groupId的命名规则：org/com.组织名称.项目名称，com表示为商业项目

### 6.如何创建一个可执行的jar包

> 1.在pom.xml中加入插件

```java
<!-- Package as an executable jar -->
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
  </plugins>
</build>
```

> 2.在maven中通过package打包就OK，打完的包位于target目录下

> 3.运行jar包，终端进入jar包所在目录，之行**java -jar xxx.jar**

### 7.分析SpringBoot原理

####7.1 pom.xml分析

```xml
<!--配置父工程    -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.2.1.RELEASE</version>
</parent>

<!--    依赖-->
<dependencies>
    <!--        web启动器依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

> 7.1.1父工程

```xml
<!--配置父工程   -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.2.1.RELEASE</version>
</parent>
```

作用：对开发过程中常见的依赖的版本进行锁定，这样我们在开发中添加依赖的时候就不用指定依赖的版本了，比如上面的spring-boot-starter-web就没有设置版本（但是注意：对于父工程中没有锁定版本号的依赖，还需要手动添加版本号，比如druid）

> 7.1.2 spring-boot-starter-web

```xml
<!--    依赖-->
<dependencies>
    <!--        web启动器依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

spring-boot-starter-web：这是一个web的启动器，提供了web开发相关的所有依赖

spring-boot-start-xxx，Springboot启动器

总结：springboot对我们日常开发中的所有场景都进行了封装，封装成了若干个启动器，如果我们在开发中需要使用什么场景就添加什么场景的启动器依赖

####7.2 主程序类分析

```java
//SpringBootApplication注解声明MySpringBootApplication为SpringBoot主程序类，表示SpringBoot应用就从这儿启动，只需要之行主程序类的main方法就可以
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
      //启动SpringBoot应用
        SpringApplication.run(MySpringBootApplication.class,args);
    }
}
```
```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(//用处不大
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
  ...
}
```
> 这里`@SpringBootApplication`注解由`@SpringBootConfiguration`、`@EnableAutoConfiguration`、`@ComponentScan`这几个注解组成，而上面的`@Target({ElementType.TYPE}) `、`@Retention(RetentionPolicy.RUNTIME)`、`@Documented`、`@Inherited`为注解的元注解，target表示该注解用在什么地方，retention表示在什么环境中使用，运行环境or变异环境？

```java
（1）@SpringBootConfiguration->SpringBoot的配置类
			@Configuration->Spring的配置类
//这两个的作用是一样的，都是申明某个类为配置类，只不过一个用于SpringBoot，一个用于Spring(SpringBoot和Spring的关系？Spring是什么？)

配置类<=>配置文件（applicationContext.xml）
  
  配置文件内容形如：
  <beans>
	  <bean id="" class=""></bean>
  </beans>

SpringBoot不推荐使用配置文件，推荐使用配置类
```

```java
(2)@EnableAutoConfiguration 开启自动配置
  	@AutoConfigurationPackage 自动配置导包
  		@Import({Registrar.class})向容器中注册组件
  获取@SpringBootApplication注解所修饰的主程序类所在的包，将该包下的所有组件注册到容器中。（这里的组件是什么？容器又是什么？）
   @Import({AutoConfigurationImportSelector.class})
  SpringBoot在启动的时候给我们注册了很多自动配置包（所以很多配置不需要我们自己配置）
```
###8. Spring initializer 快速创建Spring应用

![image-20200112173725817](/Users/liufeng/Library/Application Support/typora-user-images/image-20200112173725817.png)

**前提：保证网络环境**

在创建项目的时候，可以选择需要的模块，创建完成后，会默认指定父工程并且自动添加相关的启动器，自动创建SpringBoot的主程序类，只需要直接编写业务代码即可。 

默认创建的工程，resources资源目录下：

application.properties --- SpringBoot的默认配置文件，可以在该文件中修改SpringBoot的一些默认配置

static --- 静态资源目录（js css image  ...）

templates --- 模板目录（SpringBoot应用内嵌了Tomcat，无法解析jsp页面，一般情况下选择SpringBoot默认推荐的模板：themeleaf、freemarker）

##二、SpringBoot配置文件

SpringBoot在创建项目的时候加载很多的自动配置，可以通过修改配置文件来修改SpringBoot默认的配置

默认两种格式的配置文件：

application.properties

application.yaml

### 1. YAML简介

用来表达数据序列化的格式，以数据为中心，更适合作为配置文件（比接json、xml）

常见：xml

<server>

​	<port>8086</port>

</server>

```yaml
server: 
 port: 8086
```

### 2. YAML语法

1. YMAL以键值对来描述数据：键:(空格)值 **空格一定不能省略**
2. 层级关系通过空格（**不是tab**）来表示 ，只要是左对齐的一列数据，都是同一级别的

#### 2.1 值的写法

> (1)字面量（字符串）

直接在值的位置配置属性值即可，默认是字符串，不需要添加双引号

> (2)对象（Map）

```yaml
employee01:
 name: 张三
 age: 20
 dept: 
  depNo: 001
  depName: 技术部门
```

行内写法

```yaml
employee01:
 name: 张三
 age: 20
 dept: {depNo:001,depName:技术部门}
```

> (3)数组、集合

```yaml
employee01:
 name: 张三
 age: 20
 subjects: 
  -java
  -c
  -php
```

行内写法

```yaml
employee01:
 name: 张三
 age: 20
 subjects: [java,c,php]
```

###3. YAML属性与对象属性的绑定

```java
/**
 * 如果需要使用@ConfigurationProperties注解，那么前提是，当对象必须是Spring容器的组件
 * @ConfigurationProperties：将配置文件中的配置属性与对象中的属性进行关联
 * prefix：指定配置文件中的哪个配置进行关联（指定下一级怎么指定？）
 */
@ConfigurationProperties(prefix = "employee01")

/**
 * 将Employee所对应的对象添加为Spring容器的组件
 */
@Component
public class Employee {
    private String name;
    private Integer age;
    private String[] subjects;
    private Dept dept;
```
添加下面的依赖，可以使编写配置文件的时候出现提示（需要先完善现骨干的类）
```xml
<!--        配置处理器 能够在编写配置文件时出现提示-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
</dependency>
```