## Map

> * put->增改
> * remove->删除
> * get->查
> * Interface **Entry** ->用来存放映射的键值对



#### 一、不同的Map（HashMap、TreeMap etc.）类型的最主要区别其实就是增、删、改、查的实现不同，与之类似的是抽象类Dictionary，Dictionary有的方法Map都有。问题是Java为什么不在Dictionary上面改造，而要新搞一个Map出来？

1. HashMap,TreeMap, Hashtable, SortedMap这几者的区别

   > 1. HashMap
   >
   >    > 1. 基于HashTable的Map实现
   >    >
   >    > 2. HashMap与HashTable功能大致相同，区别是HashMap允许null value和null key，并且HashMap是unsynchronized
   >    >
   >    >    > HashMap不是线程安全的，而HashTable是线程安全的？ConcurrentHashMap并发性能高于HashTable
   >    >    >
   >    >    > > Unlike the new collection implementations, Hashtable is synchronized. If a thread-safe implementation is not needed, it is recommended to use HashMap in place of Hashtable. If a thread-safe highly-concurrent implementation is desired, then it is recommended to use java.util.concurrent.ConcurrentHashMap in place of Hashtable.
   >    >
   >    > 3. 对其集合视图的迭代所需的时间和hashmap的容量("桶"的个数)与hashmap的size之和成比例，所以如果对迭代性能要求较高的话不宜对初始容量设置太高
   >    >
   >    >    > An instance of HashMap has two parameters that affect its performance: initial capacity and load factor. The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created. The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased. When the number of entries in the hash table exceeds the product of the load factor and the current capacity, the hash table is rehashed (that is, internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets.
   >
   > 2. TreeMap
   >
   > 3. Hashtable
   >
   > 4. SortedMap

#### 二、Tips

1. key可以为null
2. 删除一个键值对其实就是删除entrySet中的一个元素
3. 并不是说两个对象equals返回false就说明这两个对象的hashCode就不同，但是为两个不同的对象返回不同的hashCode会提升hashTable的性能
4. hashCode是一个约定，约定两个不同的对象返回的值不同，Java并未做具体实现要求。实际实现是将对象的内存地址转换为一个整数
5. Map类似于Dictionary，但是函数比Dictionary更丰富
6. Iterable接口类似于Enumeration接口，但是多了一个可选的remove方法，并且方法名更短
7. 

