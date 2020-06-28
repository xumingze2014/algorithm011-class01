---
typora-copy-images-to: img
---

学习笔记

## 数组

常见写法 int a[100];

高级语言提供泛型，可以在数组中存储存放任意类型

申请数组的时候，内存管理器在内存中开辟一片连续的内存地址，每一个地址都可以通过内存管理器访问。

访问任何一个元素的时间复杂度都是O(1)，

数组插入操作时间复杂度O(n)

数组删除操作时间复杂度O(n)

```java
ArrayList
private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }
```



## 跳表

### 链表

![image-20200628205811149](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_01/img/image-20200628205811149.png?raw=true)

jdk的实现

```
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{
    transient int size = 0;

    /**
     * Pointer to first node.
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     */
    transient Node<E> last;
}
```

链表添加元素时间复杂度O(1)

链表删除元素时间复杂度O(1)

链表查找元素时间复杂度O(n)

如果链表有序的情况下是否可以提高链表查找性能？

![image-20200628210350051](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_01/img/image-20200628210350051.png?raw=true)

**跳表只适用于有序的链表**

一维的数据结构如果想要加速，常常采用的方式时升维度。多一个维度，就多一些信息，帮助查找。

个人感悟，链表查找的慢就时因为每次移动一步，如果可以一次移动两步，或者，一次移动多步就可以实现链表查找加速

![image-20200628211255282](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_01/img/image-20200628211255282.png?raw=true)



查询任意元素的时间复杂度 O(logn)

在实际使用过程中

1. 跳表由于多次调整有些地方可能跨多步
2. 跳表维护成本比较高，插入，删除时间复杂度O(logn)

空间复杂度O(n)



## 栈

先入后出

查询时间复杂度O(n)

插入，删除时间复杂度O(1)

## 队列

先入先出

查询时间复杂度O(n)

插入，删除时间复杂度O(1)

### 双端队列

![image-20200628212414745](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_01/img/image-20200628212414745.png?raw=true)

查询时间复杂度O(n)

插入，删除时间复杂度O(1)

### PriorityQueue

插入时间复杂度O(1)

取出时间复杂度O(logn)

底层具体实现可以使用heap bst treap



jdk PriorityQueue 源码分析

1.一些变量

```
private static final int DEFAULT_INITIAL_CAPACITY = 11;

/**
 * Priority queue represented as a balanced binary heap: the two
 * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
 * priority queue is ordered by comparator, or by the elements'
 * natural ordering, if comparator is null: For each node n in the
 * heap and each descendant d of n, n <= d.  The element with the
 * lowest value is in queue[0], assuming the queue is nonempty.
 */
transient Object[] queue; // non-private to simplify nested class access

/**
 * The number of elements in the priority queue.
 */
int size;

/**
 * The comparator, or null if priority queue uses elements'
 * natural ordering.
 */
private final Comparator<? super E> comparator;

/**
 * The number of times this priority queue has been
 * <i>structurally modified</i>.  See AbstractList for gory details.
 */
transient int modCount;     // non-private to simplify nested class access
```

2.插入操作

```
add
	offer
		如果元素个数大于等于队列长度
			那么需要扩容 执行 grow(i + 1);
		siftUp(i, e);
```

```
private void grow(int minCapacity) {
	// 如果元素个数比较小，队列长度加倍 如果比较大 增长50%
    int oldCapacity = queue.length;
    // Double size if small; else grow by 50%
    int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                     (oldCapacity + 2) :
                                     (oldCapacity >> 1));
    // overflow-conscious code
    if (newCapacity - MAX_ARRAY_SIZE > 0)
    	//如果需要的长度 大于  MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    	//长度 Integer.MAX_VALUE
    	//否则 MAX_ARRAY_SIZE
        newCapacity = hugeCapacity(minCapacity);
    //将元素复制
    queue = Arrays.copyOf(queue, newCapacity);
}
```

```
private void siftUp(int k, E x) {
    if (comparator != null) 
   		//siftUpUsingComparator 和 siftUpComparable 类似
        siftUpUsingComparator(k, x);
    else
        siftUpComparable(k, x);
}
```

```
private void siftUpUsingComparator(int k, E x) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (comparator.compare(x, (E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}
```

siftUpUsingComparator 思路

1. 每次数组的下标都除以2
2. 判断 这个位置的数据 是否小于等于要插入的数值
3. 如果小于等于则停止 将带插入数值插入到这个位置
4. 如果不是则重复1到3步骤，直到k不大于0

3.删除操作

```
public boolean remove(Object o) {
    int i = indexOf(o);
    if (i == -1)
        return false;
    else {
        removeAt(i);
        return true;
    }
}
```

1. 队列是否包含要删除元素
2. 不包含，返回 false
3. 包含 执行removeAt

```
E removeAt(int i) {
    // assert i >= 0 && i < size;
    modCount++;
    int s = --size;
    if (s == i) // removed last element
        queue[i] = null;
    else {
        E moved = (E) queue[s];
        queue[s] = null;
        siftDown(i, moved);
        if (queue[i] == moved) {
            siftUp(i, moved);
            if (queue[i] != moved)
                return moved;
        }
    }
    return null;
}
```

从后往前删除

如果时最后一个 直接 queue[i] = null;

如果不是最后一个

队列最后一个赋值给moved

队列最后一个赋值null

siftDown

如果队列i位置和moved一样

​	siftUp

​	如果队列i位置和moved不一样

​	返回moved

否则返回 null

