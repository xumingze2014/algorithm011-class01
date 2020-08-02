---
typora-copy-images-to: img
---

学习笔记

# 动态规划  

## 递归代码模版

```java
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
    // process result
    return;
    }
    // process current logic
    process(level, param);
    // drill down
    recur( level: level + 1, newParam);
    // restore current status
}
```

![image-20200802212401547](D:\geek_learn\algorithm011-class01\Week_06\img\image-20200802212401547.png)

## 分治代码模板

```python
def divide_conquer(problem, param1, param2, ...):
	# recursion terminator
	if problem is None:
	print_result
	return
	# prepare data
	data = prepare_data(problem)
	subproblems = split_problem(problem, data)
	# conquer subproblems
	subresult1 = self.divide_conquer(subproblems[0], p1, ...)
	subresult2 = self.divide_conquer(subproblems[1], p1, ...)
	subresult3 = self.divide_conquer(subproblems[2], p1, ...)
	…
	# process and generate the final result
	result = process_result(subresult1, subresult2, subresult3, …)
	# revert the current level states
```

## 关键点  

- 动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构  
- 共性：找到重复子问题  
- 差异性：最优子结构、中途可以淘汰次优解  



## 实战例题

[打家劫舍](https://leetcode-cn.com/problems/house-robber/)

1. 子问题
2. 状态定义
3. DP方程

假设 一开始定义dp[i] ：为0 到i房间 能偷的最大值

那么假设dp方程为 dp[i] = dp[i-1] + nums[i]

这个dp方程问题在于 第i个房子可能偷了也可能没偷

如果第i个房子偷了，那么i-1个房子就不能偷 

那么上述dp方程就不对了

那么目前用一维数组无法携带第i个房子是否偷的信息

那么考虑二维数组，多了一个维度，存储的信息也变多了

多的一个维度 

- 1 第i个房子偷了
- 0 第i个房子没偷

于是有

```
dp[i][0] = max(dp[i-1][1],dp[i-1][0])
dp[i][1] = dp[i-1][0] + nums[i]
```

 