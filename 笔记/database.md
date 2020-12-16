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

## 一、MySQL



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

    > - [Atomic Data Definition Statement Support](https://dev.mysql.com/doc/refman/8.0/en/atomic-ddl.html)
    >
    > - [ALTER DATABASE Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-database.html)
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
    >   
    >
    > - [ALTER EVENT Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-event.html)
    >
    > - [ALTER FUNCTION Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-function.html)
    >
    > - [ALTER INSTANCE Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-instance.html)
    >
    > - [ALTER LOGFILE GROUP Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-logfile-group.html)
    >
    > - [ALTER PROCEDURE Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-procedure.html)
    >
    > - [ALTER SERVER Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-server.html)
    >
    > - [ALTER TABLE Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-table.html)
    >
    > - [ALTER TABLESPACE Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-tablespace.html)
    >
    > - [ALTER VIEW Statement](https://dev.mysql.com/doc/refman/8.0/en/alter-view.html)
    >
    > - [CREATE DATABASE Statement](https://dev.mysql.com/doc/refman/8.0/en/create-database.html)
    >
    >   ```mysql
    >   CREATE {DATABASE | SCHEMA} [IF NOT EXISTS] db_name
    >       [create_option] ...
    >   
    >   create_option: [DEFAULT] {
    >       CHARACTER SET [=] charset_name
    >     | COLLATE [=] collation_name
    >     | ENCRYPTION [=] {'Y' | 'N'}
    >   }
    >   ```
    >
    >   
    >
    > - [CREATE EVENT Statement](https://dev.mysql.com/doc/refman/8.0/en/create-event.html)
    >
    > - [CREATE FUNCTION Statement](https://dev.mysql.com/doc/refman/8.0/en/create-function.html)
    >
    > - [CREATE INDEX Statement](https://dev.mysql.com/doc/refman/8.0/en/create-index.html)
    >
    > - [CREATE LOGFILE GROUP Statement](https://dev.mysql.com/doc/refman/8.0/en/create-logfile-group.html)
    >
    > - [CREATE PROCEDURE and CREATE FUNCTION Statements](https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html)
    >
    > - [CREATE SERVER Statement](https://dev.mysql.com/doc/refman/8.0/en/create-server.html)
    >
    > - [CREATE SPATIAL REFERENCE SYSTEM Statement](https://dev.mysql.com/doc/refman/8.0/en/create-spatial-reference-system.html)
    >
    > - [CREATE TABLE Statement](https://dev.mysql.com/doc/refman/8.0/en/create-table.html)
    >
    >   ```
    >   表的创建有一个非常复杂的表达式
    >   数据库中表的数量限制：MySQL不限制其表的数量，但底层的文件系统可能会限制文件夹中文件（表的表现形式）的数量，不同的存储引擎可能会限制数量，InnoDB限制最多只能创建20亿张表
    >   ```
    >
    > - [CREATE TABLESPACE Statement](https://dev.mysql.com/doc/refman/8.0/en/create-tablespace.html)
    >
    > - [CREATE TRIGGER Statement](https://dev.mysql.com/doc/refman/8.0/en/create-trigger.html)
    >
    > - [CREATE VIEW Statement](https://dev.mysql.com/doc/refman/8.0/en/create-view.html)
    >
    > - [DROP DATABASE Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-database.html)
    >
    >   ```mysql
    >   DROP {DATABASE | SCHEMA} [IF EXISTS] db_name
    >   ```
    >
    > - [DROP EVENT Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-event.html)
    >
    > - [DROP FUNCTION Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-function.html)
    >
    > - [DROP INDEX Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-index.html)
    >
    > - [DROP LOGFILE GROUP Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-logfile-group.html)
    >
    > - [DROP PROCEDURE and DROP FUNCTION Statements](https://dev.mysql.com/doc/refman/8.0/en/drop-procedure.html)
    >
    > - [DROP SERVER Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-server.html)
    >
    > - [DROP SPATIAL REFERENCE SYSTEM Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-spatial-reference-system.html)
    >
    > - [DROP TABLE Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-table.html)
    >
    > - [DROP TABLESPACE Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-tablespace.html)
    >
    > - [DROP TRIGGER Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-trigger.html)
    >
    > - [DROP VIEW Statement](https://dev.mysql.com/doc/refman/8.0/en/drop-view.html)
    >
    > - [RENAME TABLE Statement](https://dev.mysql.com/doc/refman/8.0/en/rename-table.html)
    >
    > - [TRUNCATE TABLE Statement](https://dev.mysql.com/doc/refman/8.0/en/truncate-table.html)

11. 为什么有MySQL函数的存在，不能在应用中实现吗？

    > 可以在应用中实现，不过调用MySQL函数有两个好处
    >
    > 1. 降低网络负载（意思是MySQL实现的操作更加牛逼，性能更好）
    > 2. 同样的数据库应用于不同的应用时避免重复的工作
    
12. 子查询易读易用，但是很影响性能，使用JOIN有时候可以提升500倍的性能

    > why this happen?因为join可以使用索引

13. JOIN

    > INNER, OUTER, LEFT, RIGHT, CROSS





















QUESTIONS:

1. mysqldump、mysqlpump？
2. NDB Cluster？
3. 统一数据编码方式-UTF-8
