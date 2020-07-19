学习笔记

# 深度优先搜索和广度优先搜索  

## 在树（图/状态集）中寻找特定结点  

![image-20200719203644122](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719203644122.png?raw=true)

```java
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

## 搜索 - 遍历  

- 每个节点都要访问一次  
- 每个节点都要访问一次  
- 对于节点的访问顺序不限  
   - 深度优先：depth first search
   - 广度优先：breadth first search

## 示例代码

![image-20200719210446276](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719210446276.png?raw=true)



## 深度优先搜索  

### 递归写法

![image-20200719210704399](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719210704399.png?raw=true)

### 非递归写法  

![image-20200719211044683](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719211044683.png?raw=true)

### 遍历顺序  

![image-20200719210752794](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719210752794.png?raw=true)

![image-20200719210835295](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719210835295.png?raw=true)

## 广度优先搜索  

![image-20200719211121906](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719211121906.png?raw=true)

![image-20200719211144163](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719211144163.png?raw=true)

BFS示例代码

![image-20200719212117369](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719212117369.png?raw=true)

# 贪心算法  

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。  

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能  

贪心法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。  

一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。  

## 何种情况下用到贪心算法？  

简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。  

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。  

# 二分查找  

## 二分查找的前提  

- 目标函数单调性（单调递增或者递减）  
- 存在上下界（bounded）  
- 能够通过索引访问（index accessible）

示例代码

![image-20200719213417086](https://github.com/xumingze2014/algorithm011-class01/blob/master/Week_04/img/image-20200719213417086.png?raw=true)



