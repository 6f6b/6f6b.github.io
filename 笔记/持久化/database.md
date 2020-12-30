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
   
4. 数据库的连接数

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

1. 备份类型：

   > 1. 物理与逻辑
   >
   >    > * 速度（物理更快，因为本质上他就是一个文件的拷贝；而逻辑备份需要对文件进行转换进而导出）
   >    >
   >    > * 粒度（物理备份的粒度因存储引擎的不同而不同，物理备份也可以将日志和配置文件备份；逻辑备份的粒度可以分为数据库服务器、数据库、数据表这几个粒度，逻辑备份无法备份日志、配置或其他相关的非数据库文件）
   >    > * 移植性（物理备份要求其他的机器具备相同或相似的硬件性质；逻辑备份移植性更好）
   >    > * 空间（物理更紧凑、更小；逻辑备份较大）why？
   >    > * 停机（物理备份需要server处于停机状态或进行锁定；逻辑备份需要在server运行时进行备份）
   >
   > 2. 在线与离线（区别在于是否关闭server）
   >
   >    > * 在线备份：对客户端侵入性更小，需要适当上锁防止数据在备份期间被修改导致损害数据完整性
   >    > * 离线备份：因为需要关机，那么为了防止影响客户端我们可以关闭副本，从副本中进行备份；简单，因为没有来自客户端的影响
   >
   > 3. 全量和增量
   >
   >    > MySQL有很多方法实现全量备份；通过server的记录数据变化的二进制日志文件使得增量备份变为可能
   >
   > others：
   >
   > * 热备份、冷备份、暖备份（冷热分指server是否关闭；暖指server未关闭，但是被锁定防止数据被修改）

2. 备份调度、压缩、加密

   > MySQL均不提供备份的调度、压缩、加密，所以需要借助文件系统或者其他的第三方的工具来实现这几个功能
   
3. 备份工具

   > * 逻辑备份
   >
   >   ```mysql
   >   --备份
   >   mysqldump --databases db1,db2.. -u root -p > backup.sql
   >   --恢复
   >   1.在终端
   >   mysql -u root -p backup.sql
   >   2.mysql 中
   >   source  backup.sql
   >   ```
   >
   > * 物理备份
   >
   >   ```
   >   how to ?
   >   ```
   >
   >   



#### 2.3 Optimization

从三个角度入手：

* 数据库

  * 数据库表结构是否合理？field是否是正确的数据类型？列数多少是否设置的合适（根据不同的工作类型）

    > note:高频更新的数据一般建立成多个表，每个表有较少的几个列，而不是很少的表，每个表有多个列（这回造成数据库需要分析大量的数据）

  * 是否正确的设置索引？

  * 是否为每个表设置了正确的存储引擎？InnoDB（事务性存储引擎）、MyISAM（非事务性存储引擎）的选择对性能和扩展性的影响非常大

    > InnoDB相对来讲更为牛逼，尤其是在处理高并发的场景下，而MyISAM则更擅长读较多的场景

  * 表是否采用了合适的`行格式`？

  * 应用程序是否设置了合适的上锁策略

  * 用于缓存的内存空间大小配置是否正确？要大到足够hold住高频访问，但又不能超过物理内存大小进而导致分页（分页是什么？）

    > 主要是配置InnoDB的buffer pool 或 MyISAM的key cache

  * ##### 索引

    > 1. Primary Key Index、Unique Key Index、普通索引、全文索引、空间索引
    >
    > 2. 索引实现的数据结构有`B-tree`、`Hash`
    >
    > 3. 建索引背后发生了什么？
    >
    >    > 构建了一棵B树，对于hash索引而言，我认为什么也不需要做，其只需要有一个hash函数对key和内存地址进行转换即可
    >
    > 4. 二级索引可以分为空间索引、列索引、复合索引
    >
    > 5. 主键有相关的索引，因为主键不能为空，所以可以在物理层面进行有序排列，然后进行超快查询，一个表即便没有明显的主键列，我们也可以自己给其添加一个，以便快速查询。
    >
    > 6. whats the fucking left-prefix rule？
    >
    >    > https://orangematter.solarwinds.com/2019/02/05/the-left-prefix-index-rule/
    >
    > 7. NDB Cluster？
    >
    > 8. 统一数据编码方式-UTF-8
    >
    > 9. 查询分页比较大的时候，怎么提高查询速度
    >
    > 10. 查询分表怎么分？（官方建议数据量达到2000万以上才分库分表）
    >
    > 11. 索引（B树索引、哈希索引（只能用在内存型的存储引擎中）
    >
    >     > [adaptive hash index](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_adaptive_hash_index), [B-tree](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_b_tree), [child table](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_child_table), [clustered index](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_clustered_index), [column index](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_column_index), [composite index](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_composite_index), [covering index](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_covering_index), [foreign key](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_foreign_key), [hash index](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_hash_index), [parent table](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_parent_table), [partial index](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_partial_index), [primary key](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_primary_key), [query](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_query), [R-tree](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_r_tree), [row](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_row), [secondary index](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_secondary_index), [table](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_table). [index](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_index), [InnoDB](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_innodb).
    >     >
    >     > * B树结构（B树节点可以有多个子节点，而二叉树只能有最多2个子节点）
    >     > * 哈希
    >
    > 12. 如何查询数据库中某个列值最大的那条数据
    >
    >     > 1. Max函数
    >     > 2. 倒序查一条
    >     > 3. LEFT JOIN

* 硬件

  * Disk seek ，做一次seek平均时间少于10ms，更换Disk通常不会有较大性能提升，好的方案是分成多个Disk
  * Disk Read&Write，分发速度至少10-20M/s，可以再多个Disk中并行的读
  * CPU周期，相对于内存的大小对性能的影响而言，过大的表通常是性能限制的主要因素，小的表通常不会有问题。（这里的大小表是指数据行数多还是列数多，还是两者兼具？）

* SQL语句的可移植性和性能之间的平衡

  * 有些适用于MySQL的性能优化语句不一定适合其他的数据库管理系统，因此需要 `/*! */` 进行适配

#### 2.4 Security

1. 为安全计，需要考虑的几个因素

   > 1. 密码是否足够安全、不给用户不必要的授权、防止SQL注入和数据损坏
   > 2. 安装过程中的加密：涉及日志文件以及应用相关的所有数据文件，这些文件对没有授权的用户应该都是不可读且不可写的
   > 3. 账号管理
   > 4. 加密相关的插件提供了哪些特性
   > 5. 对访问数据库的用户的host进行限制，或者只允许进行本地访问
   > 6. 数据备份

2. security guidelines

   > 1. **永远不要授权除root账号以外的其他账号访问mysql数据库下的user表**
   >
   > 2. 清除如何通过`GRANT`、`REVOKE`来管理权限，**永远不要将访问权限开放给所有的host**
   >
   > 3. 不要存密码的明文在数据库中，可以通过hash(hash(明文)+salt)存入
   >
   > 4. 密码安全意识
   >
   >    > * 不要直接使用一个单词，如果想使用一个单词，可以用这个单词中字母在键盘左边或右边的字母替代，如fish->duag
   >    > * 用一句话中的单词的首字母代替，如：four score and seven years ago -> fsasya
   >
   > 5. 开启防火墙
   >
   >    > 可用`telnet server_host port` 来检测端口是否开启

#### 2.5 Transaction

	transaction are atomic units of work that can be commited or rolled back

1. ACID（atomicity, consistency, isolation, and durability.分别为原子性、一致性、隔离性、持久性），原子性指不可分割性

2. 事务解决什么问题？怎么解决的？带来什么新的问题？新的问题如何解决？

   > 1. 有时候，几个操作需要一起成功或一起失败，事务就是解决这个问题。从概念上来讲，事务是一个原子单位的工作单元，这个工作单元包含了一条或多条操作。
   > 2. 

3. 有些语句不能被回滚

   > DDL

4. autocommit

   > 造成的效果是每一个语句都被start transaction和commit包围，也就是说每一条语句都是一个原子操作

5. 隔离级别

   > * READ UNCOMMITTED 读未提交
   >
   > * READ COMMITTED 读已提交
   >
   > * REPEATABLE READ 可重复读，默认的隔离级别
   >
   > * SERIALIZABLE 序列化
   >
   >   [涉及隔离级别的介绍、读产生的几种问题(脏读、不可重复度、幻读)及解决方案](https://en.wikipedia.org/wiki/Isolation_%28database_systems%29#Non-repeatable_reads)

6. Transaction Access Model

   > * READ WRITE 默认
   >
   > * READ ONLY 可提高性能；事务中不能对表进行修改，但是可对临时表进行修改

7. 事务属性设置影响到的域

   > * GLOBAL 对所有接下来的其他session有效，但对当前session无效
   > * SESSION 对当前session中所有接下来的事务有效；可以在事务中执行，但是对当前事务不生效
   > * Without any `SESSION` or `GLOBAL` keyword：仅对当前session的下一个事务有效；不能在事务中执行

8. MVCC

   > MySQL通过undo log来实现一致性读
   >
   > Undo logs in the rollback segment are divided into insert and update undo logs. Insert undo logs are needed only in transaction rollback and can be discarded as soon as the transaction commits.**Update undo logs are used also in consistent reads**, but they can be discarded only after there is no transaction present for which `InnoDB` has assigned a snapshot that in a consistent read could need the information in the update undo log to build an earlier version of a database row.

#### 2.6 Event

1. event 用来执行定时任务，类似于Linux中的crontab，通过SQL语句来创建和修改event

#### 2.7 Log

1. 日志记录了些什么东西？
2. 日志文件存储在哪里？
3. 日志文件如何查看？
4. 日志文件大小如何设置？
5. 日志超过了日志文件大小上限怎么办？

#### 2.8 InnoDB

#####2.8.1 Tips

1. row format [详细对比](https://dev.mysql.com/doc/refman/8.0/en/innodb-row-format.html)

   > * 表中的行数据在磁盘中存储的格式，可以设置的值有`REDUNDANT`,`COMPACT`,`COMPRESSED`,`DYNAMIC`，这个`COMPRESSED`是InnoDB引擎中新增的，可以提高存储的性能
   > * 这个值的设置可以通过数据库配置选项`innodb_default_row_format`来设置（默认是`DYNAMIC`)，也可以在建表的时候单独设置
   > * 比较，一个比一个压缩更牛逼（工作负载受缓存命中和磁盘IO限制则采用压缩率较高的，受CPU限制则采用压缩率较低的）
   >   * REDUNDANT 最老的格式，基本不用了
   >   * COMPACT 相比于REDUNDANT来讲减少了约20%的磁盘空间 
   >   * DYNAMIC 相比COMPACT 增强了对变长字段的存储能力，增加了对大的前缀索引的支持。这种格式使得长的变长字段被存储在包含行数据的page之外，因此非常适合包含大对象的表（因为大的字段通常不会用来作为查询条件，所以他们通常不需要被加载到缓存池中，这样就减少了磁盘IO）
   >   * COMPRESSED 相比DYNAMIC 增加了对表和索引数据的压缩支持

2. buffer （主要目的是减少磁盘IO，将多次的小的磁盘IO调整为少的较大的磁盘IO）LRU（least recently used）算法--优化**midpoint-insertion-strategy**

   > * buffer pool 缓存表和索引的一个内存区域
   > * doublewrite buffer 先写到doublewrite buffer中，再写入数据文件，为了防止写入数据文件过程中发生故障。可以关闭
   > * change buffer

##### 2.8.2 优势

#####	2.8.3 局限性

1. 一张表最多1017列（包括虚拟生成的列）

2. 一张表最多64个二级索引

3. 每个多列索引最多包含16列

4. 每一行的大小限制

   > * 没有变长字段：大小限制为page size的一半，但不超过16KB，如：InnoDB默认pagesize为16KB，则单行数据最大为8KB
   > * 有变长字段（LONGBLOB、LONGTEXT、BLOB、TEXT）：因为这些字段的值（当整个行已经超过pagesize的一半）是存储在另外一个page中的，因此这样的行最大不超过4GB

5. 日志文件总和的大小限制为512GB


























TIPS：

1. MySQL InnoDB Cluster?

   > MySQL InnoDB Cluster is a collection of products that work together to provide a high availability solution. A group of MySQL servers can be configured to create a cluster using MySQL Shell. The cluster of servers has a single source, called the primary, which acts as the read-write source. Multiple secondary servers are replicas of the source. A minimum of three servers are required to create a high availability cluster. A client application is connected to the primary via MySQL Router. If the primary fails, a secondary is automatically promoted to the role of primary, and MySQL Router routes requests to the new primary.

2. NDB Cluster？

   > NDB Cluster provides a high-availability, high-redundancy version of MySQL adapted for the distributed computing environment. See [Chapter 23, *MySQL NDB Cluster 8.0*](https://dev.mysql.com/doc/refman/8.0/en/mysql-cluster.html), which provides information about MySQL NDB Cluster 8.0.


QUESTIONS:

1. mysqldump、mysqlpump？

2. 统一数据编码方式-UTF-8

4. 查询分页比较大的时候，怎么提高查询速度

5. 查询分表怎么分？（官方建议数据量达到2000万以上才分库分表）


参考文档：

> [MySQL官方文档](https://dev.mysql.com/doc/refman/8.0/en/)
>
> > [InnoDB 中MVCC的实现](https://dev.mysql.com/doc/refman/8.0/en/innodb-multi-versioning.html)
>
> [guru99中对SQL的入门介绍](https://www.guru99.com/sql.html)
>
> [How does MVCC (Multi-Version Concurrency Control) work](https://vladmihalcea.com/how-does-mvcc-multi-version-concurrency-control-work/)
>
> [MVCC多版本并发控制](https://www.jianshu.com/p/8845ddca3b23)

