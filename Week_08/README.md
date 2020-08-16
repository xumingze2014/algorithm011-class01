学习笔记


## 排序算法

### 如何评价一种排序算法

既然是算法，肯定要分析时间复杂度、空间复杂度。关于时间复杂度是指比较和交换次数，关于空间复杂度是指排序算法申请的额外空间，**原地排序**就是特指空间复杂度是 `O(1)` 的排序算法。 另外排序算法还涉及**稳定性**的评价指标，是指对于比较结果相同的数据，如果每次排序数据顺序都是一样的，那么则是稳定的排序算法，反之则是不稳定的排序算法。

### 冒泡排序（Bubble Sort）

<img src="https://img.liuhu.me/2020/08/bubble-sort.gif" width="400px">

冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。

```java
public static void bubbleSort(int[] nums) {
    int length = nums.length;
    if (length <= 1) {
        return;
    }
    for (int i = 0; i < length; i++) {
        // 提前退出冒泡循环的标志位
        boolean flag = false;
        for (int j = length - 1; j > i; j--) {
            if (nums[j] > nums[j - 1]) { // 交换
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
                flag = true;  // 表示有数据交换
            }
        }
        if (!flag) {
            break;  // 没有数据交换，提前退出
        }
    }
}
```

### 插入排序（Insertion Sort）



插入排序的算法思想就是，将数组中的数据分已排序区间和未排序区间。初始状态就是数组的第一个元素为已排序区间，右边为未排序区间。依次从未排序区间中取出元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。

```java
public static void insertionSort(int[] nums) {
    int length = nums.length;
    if (length <= 1) {
        return;
    }
    for (int i = 1; i < length; i++) {
        int value = nums[i];
        int j = i - 1;
        // 查找插入的位置
        while (j >= 0) {
            if (nums[j] > value) {
                nums[j + 1] = nums[j];  // 数据移动
                j--;
            } else {
                break;
            }
        }
        nums[j + 1] = value; // 插入数据
    }
}
```

### 选择排序（Selection Sort）

<img src="https://img.liuhu.me/2020/08/selection-sort.gif" width="400px">

选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。

```java
public static void selectionSort(int[] nums) {
    int length = nums.length;
    if (length <= 1) {
        return;
    }
    for (int i = 0; i < length; i++) {
        int minIdx = i;
        for (int j = i; j < length; j++) {
            if (nums[minIdx] > nums[j]) {
                minIdx = j;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[minIdx];
        nums[minIdx] = tmp;
    }
}
```

### 归并排序（Merge Sort）

<img src="https://img.liuhu.me/2020/08/merge-sort.gif" width="400px">

归并排序就使用了分治的思想，先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。

```java
public static void mergeSort(int[] nums) {
    int length = nums.length;
    if (length <= 1) {
        return;
    }
    mergeSort(nums, 0, length - 1);
}
private static void mergeSort(int[] nums, int left, int right) {
    if (right <= left) {
        return;
    }
    int mid = (left + right) >> 1;
    mergeSort(nums, left, mid);
    mergeSort(nums, mid + 1, right);
    merge(nums, left, mid, right);
}
private static void merge(int[] nums, int left, int mid, int right) {
    int[] tmp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
    }
    while (i <= mid) {
        tmp[k++] = nums[i++];
    }
    while (j <= right) {
        tmp[k++] = nums[j++];
    }
    System.arraycopy(tmp, 0, nums, left, tmp.length);
}
```



### 快速排序（Quick Sort）

<img src="https://img.liuhu.me/2020/08/quick-sort.gif" width="400px">

快排也是利用分治的思想，先从数组中取标杆 pivot，将 pivot 小的元素放在 pivot 左边，大的元素放在 pivot 右边，然后依次对右边和右边的子数组继续用同样的方式排序，以达到整个序列有序。图中的例子选取 pivot 是待排数组的最右侧元素。

```java
public static void quickSort(int[] nums) {
    int length = nums.length;
    if (length <= 1) {
        return;
    }
    quickSort(nums, 0, length - 1);
}

private static void quickSort(int[] nums, int left, int right) {
    if (left < right) {
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }
}

private static int partition(int[] nums, int left, int right) {
    // pivot: 标杆位置，counter: ⼩于pivot的元素的个数
    int pivot = right, counter = left;
    for (int i = left; i < right; i++) {
        if (nums[i] < nums[pivot]) {
            int temp = nums[counter];
            nums[counter] = nums[i];
            nums[i] = temp;
            counter++;
        }
    }
    int temp = nums[pivot];
    nums[pivot] = nums[counter];
    nums[counter] = temp;
    return counter;
}
```



### 堆排序（Heap Sort）

<img src="https://img.liuhu.me/2020/08/heap-sort.gif" width="400px">

数组元素建立大顶堆，取出堆顶元素和堆尾元素交换，再重新调整成大顶堆

```java
/**
 * 堆排序
 * @param nums 待排序数组
 */
public static void heapSort(int[] nums) {
    int length = nums.length;
    //初始化大顶堆
    for (int i = (length - 2) / 2; i >= 0; i--) {
        adjustHeap(nums, i, length);
    }
    //每次取堆顶元素与堆尾元素交换，再重新调整成大顶堆
    for (int i = length - 1; i > 0; i--) {
        int temp = nums[0];
        nums[0] = nums[i];
        nums[i] = temp;
        adjustHeap(nums, 0, i);
    }
}
/**
 * 调整堆->大顶堆
 *
 * @param nums  待排序数组
 * @param top    堆顶元素下标
 * @param length 待调整的堆长度
 */
public static void adjustHeap(int[] nums, int top, int length) {
    int temp = nums[top]; //暂存堆顶元素
    //比较左右子树根结点，从大的子树向下遍历调整堆
    for (int i = 2 * top + 1; i < length; i = i * 2 + 1) {
        //保证i为较大的子树下标
        if (i < length - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (temp > nums[i]) {
            break;
        }
        nums[top] = nums[i];
        top = i;//向下搜索
    }
    nums[top] = temp;
}
```



## 总结

归并排序和快排都使用来分治的思想，区别是归并排序的处理过程是由下到上的，先处理子问题，然后再合并（merge），而快排正好相反，它的处理过程是由上到下的，先分区（partition），然后再处理子问题。

归并排序虽然时间复杂度很稳定，但是不是原地排序算法，空间复杂度为 O(n)，所以它也没有快排应用广泛。快排虽然最坏情况下的时间复杂度是 O(n²)，但是平均情况下时间复杂度是 O(nlogn)。而且快排时间复杂度退化到 O(n²) 的概率非常小，我们可以通过合理地选择 pivot 来避免这种情况。

| **排序算法** | **平均时间复杂度** | **最坏时间复杂度** | **最好时间复杂度** | **空间复杂度** | **稳定性** |
| :----------: | :----------------: | :----------------: | :----------------: | :------------: | :--------: |
| **冒泡排序** |       O(n²)        |       O(n²)        |        O(n)        |      O(1)      |    稳定    |
| **选择排序** |       O(n²)        |       O(n²)        |       O(n²)        |      O(1)      |   不稳定   |
| **插入排序** |       O(n²)        |       O(n²)        |        O(n)        |      O(1)      |    稳定    |
| **快速排序** |      O(nlogn)      |       O(n²)        |      O(nlogn)      |    O(nlogn)    |   不稳定   |
|  **堆排序**  |      O(nlogn)      |      O(nlogn)      |      O(nlogn)      |      O(1)      |   不稳定   |
| **希尔排序** |      O(n^1.3)      |       O(n²)        |        O(n)        |      O(1)      |   不稳定   |
| **归并排序** |      O(nlogn)      |      O(nlogn)      |      O(nlogn)      |      O(n)      |    稳定    |
| **计数排序** |       O(n+k)       |       O(n+k)       |       O(n+k)       |     O(n+k)     |    稳定    |
| **基数排序** |       O(n*k)       |       O(n*k)       |       O(n*k)       |     O(n+k)     |    稳定    |

## LRU

### 代码模板

```java
public class LRUCache {
    private Map<Integer, Integer> map; 
    public LRUCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        return map.get(key);   
    }
    public void put(int key, int value) {
        map.put(key,value);
    }
    private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
        int maximumCapacity;
        LinkedCappedHashMap(int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity; 
        }
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    } 
} 
```

## 位运算

### 判断奇偶

- 奇数：x % 2 == 1 <======> (x & 1) == 1
- 偶数：x % 2 == 0 <======> (x & 1) == 0

### x >> 1 <======> x / 2

- mid = (left + right) / 2 <======> mid = (left + right) >> 1

- 清零最低位的 1 （从右往左数，第一个为 1 的位置）：x = x & (x - 1)
- 得到最低位的 1 （同上）：x & -x
- 得到 0 ：x & ~x



### 移出去的补0 左移: <<

示例: 0011 => 0110
右移: <<
示例: 0110 => 0011

### 常用的位运算:

#### 按位或: |

示例: 0011
-----=> 1011
1011

#### 按位与: &

示例: 0011
-----=> 0011
1011

#### 按位取反: ~

示例: 0011 => 1100

按位异或(相同为0不同为1) : ^
示例: 0011
-----=> 1000
1011

#### 异或操作的一些特点

1. x ^ 0 = x
2. x ^ 1s = ~x //注意1s = ~0，即1s代表的是全1
3. x ^ (~x) = 1s
4. x ^ x = 0
5. c = a ^b => a ^ c = b, b ^ c = a //交换两个数
6. a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative

#### 指定位置的位运算

1. 将x最右边的n位清零: x & (~0 << n)
2. 获取x的第n位值(0或者1): (x >> n) & 1
3. 获取x的第n位的幂值: x & (1 << n)
4. 仅将第n位置为1: x | (1 << n)
5. 仅将第n位置为0: x & (~(1 << n))
6. 将x最高位至第n位(含)清零: x & ((1 << n) - 1)
7. 判断奇数偶数: (x & 1) == 1(奇数); (x & 1) == 0(偶数)
8. x >> 1 => x / 2
9. x = x & (x - 1) 清零最低位的1
10. x & -x => 得到最低位的1
11. x & ~x => 0