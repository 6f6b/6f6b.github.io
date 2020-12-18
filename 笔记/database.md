# 数据库相关的学习笔记（涉及MySQL、Redis、MongoDB...）

数据库技术对比https://www.cnblogs.com/xrq730/p/11039384.html

## 一、DBMS

1. DBMS使得我们更好的存取、管理数据，那么是因为DBMS提供了哪些特性导致的呢？

   > 1. 对现实世界中的事物的映射
   > 2. 表之间建立关系
   > 3. 数据保护
   > 4. 数据一致性（如何实现这一功能的？）
   > 5. 查询处理

2. ACID

   > Atomicity, Consistency, Isolation, and Durability 即原子性、一致性、隔离性、持久性

3. 数据服务的几种架构

   > 1. 一层：客户端、服务端、数据库都在一台机器上，比如嵌入式数据库
   >
   > 2. 二层：客户端在一边，数据库+服务在一边，这种情况比较少见
   >
   > 3. 三层：客户端、服务端、数据库各在一台机器上
   >
   >    <img src="../../JAVAWeb/images/091318_0745_DBMSArchite3.png" style="zoom:50%;" />

## 二、MySQL

#### 2.1 Sheet

1. MySQL是一个数据库管理系统（DBMS），跟它类似的还有Oracle、SqlServer..

2. SQL语句也需要被编译的

3. MySQL最开始是MySQL AB公司的产品，后来该公司被Sun公司收购，再后来Sun被Oracle收购，所以MySQL现在是Oracle公司的产品

4. 3306端口因为是MySQL默认的端口号，也是常用的端口号，所以容易被攻击

5. 统一数据编码方式-UTF-8

6. MySQL的主要特性

   > * 内部结构和可移植性
   >
   >   > 1. Written in C and C++
   >   > 2. 其设计使得在多核CPU的情况下可以很容易的使用内核线程进行多线程工作
   >   > 3. 提供了事务性和非事务性存储引擎
   >   > 4. 使用了非常快的B树磁盘表（？）和索引压缩（？）
   >   > 5. 使用了非常快的基于线程的内存分配系统
   >   > 6. 使用优化的嵌套循环join快速执行join `Executes very fast joins using an optimized nested-loop join.`
   >   > 7. 实现了内存中的哈希表，并以此作为临时表
   >   > 8. 作为一个分离的软件在客户端网络环境/服务端网络环境中供数据库使用，也可以作为一个库的形式被内嵌到独立的应用中去
   >
   > * 加密
   >
   >   > 1. 有一个非常灵活和安全的授权/密码系统，使用了基于主机的验证方案
   >   > 2. 当连接数据库服务的时候，所有的密码流量都被加密
   >
   > * 伸缩性和局限性
   >
   >   > - Support for large databases. We use MySQL Server with databases that contain **50 million** records. We also know of users who use MySQL Server with **200,000** tables and about **5,000,000,000 **rows.
   >   > - Support for up to 64 indexes per table. Each index may consist of 1 to 16 columns or parts of columns. The maximum index width for [`InnoDB`](https://dev.mysql.com/doc/refman/8.0/en/innodb-storage-engine.html) tables is either 767 bytes or 3072 bytes. See [Section 15.22, “InnoDB Limits”](https://dev.mysql.com/doc/refman/8.0/en/innodb-limits.html). The maximum index width for [`MyISAM`](https://dev.mysql.com/doc/refman/8.0/en/myisam-storage-engine.html) tables is 1000 bytes. See [Section 16.2, “The MyISAM Storage Engine”](https://dev.mysql.com/doc/refman/8.0/en/myisam-storage-engine.html). An index may use a prefix of a column for [`CHAR`](https://dev.mysql.com/doc/refman/8.0/en/char.html), [`VARCHAR`](https://dev.mysql.com/doc/refman/8.0/en/char.html), [`BLOB`](https://dev.mysql.com/doc/refman/8.0/en/blob.html), or [`TEXT`](https://dev.mysql.com/doc/refman/8.0/en/blob.html) column types.

7. SQL的几种类型

   > 1. Data Definition Language (DDL) allows you to create objects like Schemas, Tables in the database（创建数据库和数据表）
   > 2. Data Control Language (DCL) allows you to manipulate and manage access rights on database objects（设置数据库或数据表的访问权限）
   > 3. Data Manipulation Language (DML) is used for searching, inserting, updating, and deleting data, which will be partially covered in this programming tutorial.（增删改查）

8. SQL处理步骤

   > <img src="../../JAVAWeb/images/sql-tutorial.png" style="zoom:60%;" />

9. 优化SQL性能的两个关键点

   > 1. 存数据时采用正确的结构
   > 2. 读数据时采用合适的方法

10. 主要用到的语句

   > - https://dev.mysql.com/doc/refman/8.0/en/sql-statements.html
   >
   > - 数据库修改
   >
   >   ```mysql
   >   ALTER {DATABASE | SCHEMA} [db_name]
   >       alter_option ...
   >   
   >   alter_option: {
   >       [DEFAULT] CHARACTER SET [=] charset_name
   >     | [DEFAULT] COLLATE [=] collation_name
   >     | [DEFAULT] ENCRYPTION [=] {'Y' | 'N'}
   >     | READ ONLY [=] {DEFAULT | 0 | 1}
   >   }
   >   
   >   note:READ ONLY 这个选项在数据库迁移的时候非常有用，可以保证在迁移过程中数据不被修改
   >   ```
   >
   > - 表的创建
   >
   >   ```mysql
   >   表的创建有一个非常复杂的表达式
   >   数据库中表的数量限制：MySQL不限制其表的数量，但底层的文件系统可能会限制文件夹中文件（表的表现形式）的数量，不同的存储引擎可能会限制数量，InnoDB限制最多只能创建20亿张表
   >   ```
   >
   >   

11. 为什么有MySQL函数的存在，不能在应用中实现吗？

    > 可以在应用中实现，不过调用MySQL函数有两个好处
    >
    > 1. 降低网络负载（意思是MySQL实现的操作更加牛逼，性能更好）
    > 2. 同样的数据库应用于不同的应用时避免重复的工作
    
12. 子查询易读易用，但是很影响性能，使用JOIN有时候可以提升500倍的性能

    > why this happen?因为join可以使用索引

13. JOIN

    > INNER, OUTER, LEFT, RIGHT, CROSS
    
12. View

    > * View本质上就是一个SELECT SQL语句
    > * 执行Insert、update、delete是可以的，它会影响到底层的table，一般不执行这些语句。
    >
    > * 使用view的2个动机：
    >
    > 1. 增加复用性
    > 2. 增加安全性，可只暴露需要暴露的字段

15. 将索引用在经常更新的表上是非常影响性能的，因为更新表的同时也要更新大量索引。最好的是用在经常select而不经常更新(包括update、delete、insert)的表中

#### 2.2 Backup and Recovery

#### 2.3 Optimization

从三个角度入手：

* 数据库

  * 数据库表结构是否合理？field是否是正确的数据类型？列数多少是否设置的合适（根据不同的工作类型）

    > note:高频更新的数据一般建立成多个表，每个表有较少的几个列，而不是很少的表，每个表有多个列（这回造成数据库需要分析大量的数据）

  * 是否正确的设置索引？

  * 是否为每个表设置了正确的存储引擎？InnoDB（事务性存储引擎）、MyISAM（非事务性存储引擎）的选择对性能和扩展性的影响非常大

    > InnoDB相对来讲更为牛逼，尤其是在处理高并发的场景下，而MyISAM则更擅长读较多的场景以及地并发中

  * 表是否采用了合适的`行格式`？

  * 应用程序是否设置了合适的上锁策略

  * 用于缓存的内存空间大小配置是否正确？要大到足够hold住高频访问，但又不能超过物理内存大小进而导致分页（分页是什么？）

    > 主要是配置InnoDB的buffer pool 或 MyISAM的key cache

* 硬件

  * Disk seek ，做一次seek平均时间少于10ms，更换Disk通常不会有较大性能提升，好的方案是分成多个Disk
  * Disk Read&Write，分发速度至少10-20M/s，可以再多个Disk中并行的读
  * CPU周期，相对于内存的大小对性能的影响而言，过大的表通常是性能限制的主要因素，小的表通常不会有问题。（这里的大小表是指数据行数多还是列数多，还是两者兼具？）

* SQL语句的可移植性和性能之间的平衡

  * 有些适用于MySQL的性能优化语句不一定适合其他的数据库管理系统，因此需要 `/*! */` 进行适配

#### 2.4 Security






















QUESTIONS:

1. mysqldump、mysqlpump？

2. NDB Cluster？

3. 统一数据编码方式-UTF-8

4. 查询分页比较大的时候，怎么提高查询速度

5. 查询分表怎么分？（官方建议数据量达到2000万以上才分库分表）

6. 如何查询数据库中某个列值最大的那条数据

   > 1. Max函数
   > 2. 倒序查一条
   > 3. LEFT JOIN



参考文档：

> https://www.guru99.com/sql.html
>
> https://dev.mysql.com/doc/refman/8.0/en/