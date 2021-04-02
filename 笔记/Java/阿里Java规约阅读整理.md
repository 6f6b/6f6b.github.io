## 一、编程规约

1. 集合处理

   1. 【参考】合理利用好集合的有序性(sort)和稳定性(order)，避免集合的无序性(unsort)和不稳 定性(unorder)带来的负面影响。

      说明：有序性是指遍历的结果是按某种比较规则依次排列的。稳定性指集合每次遍历的元素次序是一定 的。如：ArrayList 是 order/unsort；HashMap 是 unorder/unsort；TreeSet 是 order/sort。

      > 这里的有序性和稳定性指什么意思？虽有说明，但亦不是很清楚。