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
   >    >    
   >    > 4. HashMap下面有table[Entry]、loadfactor、threshold这几个属性，区别于Hashtable的是table[Entry]的容量总是2的幂，当存入key-value时，HashMap会对key再做一次hash处理使得更均匀的分布在hash表中，处理后的key值与hash表的长度-1做&处理，如table的长度为1000，则-1后变成0111，这使得key值&处理后必定落在table中，当某个桶中存入的个数达到TREEIFY_THRESHOLD时，先要判断是table容量否达到MIN_TREEIFY_CAPACITY这个值，若没达到则先进行扩容，若已达到则开始对这个桶中的链表进行树化处理，将其搞成一个红黑树，对树中的某个元素进行删除时可参考对树中节点的删除。随着key-value持续的添加达到下一个扩容操作时，在扩容的时候会对装树的桶进行处理，判断树的节点数是否达到砍树的值UNTREEIFY_THRESHOLD，若没达到则不管，若达到了则根据hash值分为高低两棵树，低树放在table的低位，根据是否达到UNTREEIFY_THRESHOLD的条件来决定是否砍树，高树放在table的高位，根据是否达到UNTREEIFY_THRESHOLD来决定是否砍树
   >    >
   >    >    > ```
   >    >    > static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16 table的默认初始容量
   >    >    > 
   >    >    > static final int MAXIMUM_CAPACITY = 1 << 30;	table的最大容量
   >    >    > 
   >    >    > static final float DEFAULT_LOAD_FACTOR = 0.75f;	默认负载系数
   >    >    > 
   >    >    > static final int TREEIFY_THRESHOLD = 8;	桶里的节点个数超过这个值且table超过MIN_TREEIFY_CAPACITY则对桶中的值进行树化
   >    >    > 
   >    >    > static final int UNTREEIFY_THRESHOLD = 6; 扩容时若树的节点数低于或等于这个值则砍树
   >    >    > 
   >    >    > static final int MIN_TREEIFY_CAPACITY = 64;
   >    >    > ```
   >
   > 2. TreeMap
   >
   > 3. Hashtable
   >
   >    > * Hashtable这个类下面有table[Entry]、loadfactor、threshold这几个关键属性，其中Entry这个类下面有key、value、next这几个属性，Hashtable存储的映射就是以Entry的形式存储的。
   >    >
   >    > * 当存入一个key-value映射对，首先会拿到key的hash值创建一个Entry实例，然后这个key的hash值对table[Entry]的长度取余，取余所得的值即为这个Entry实例在table[Entry]中的位置，问题是有可能两个不同的key的hash值可能相同，也可能两个不同的hash值取余后所得的值相同，比如都为2，那么这两个Entry都会存入table[2]的位置，这是后加入进来的Entry就会作为先加入进来的Entry的next属性，也就是形成了一个链表。
   >    > * table[Entry]这个数组的每一个位置代表一个“桶(bucket)”
   >    > * threshold的值=loadfactor*初始容量，loadfactor越低则性能越好，但是也就越浪费空间，为什么呢？因为负载系数决定了table[Entry]何时扩容（当所有的Entry数目超过threshold时进行扩容），loadfactor越高则threshold越高，则扩容时机越晚，假设loadfactor为10000，初始容量为2，则table[Entry]的每个桶中的链表长度平均为5000，链表越长，查询性能越慢
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

