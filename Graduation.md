---
typora-copy-images-to: img
---

# 毕业总结

不想草率的把前面的每周总结合并放在一起。

想来想去，还是感觉动态规划和字符串匹配相关内容理解的不到位

于是结合网上资源回顾下这部分内容

## 动态规划

参考知乎上力扣官方账号提供的文章

链接 https://zhuanlan.zhihu.com/p/150516970

**宝石挑选**

### **问题引入**

小 Q 是一个宝石爱好者。

这一天，小 Q 来到了宝石古董店，店家觉得小 Q 是个宝石行家，于是决定和小 Q 玩一个游戏。

游戏是这样的，一共有 ![[公式]](https://www.zhihu.com/equation?tex=n) 块宝石，每块宝石在小 Q 心中都有其对应的价值。注意，由于某些宝石质量过于差劲，因此存在只有店家倒贴钱，小 Q 才愿意带走的宝石，即价值可以为负数。

小 Q 可以免费带走一个连续区间中的宝石，比如区间 $[1,3]$ 或区间 $[2,4]$中的宝石。

请问小 Q 能带走的最大价值是多少？

**暴力解法**

枚举所有区间，找出累加和最大的区间。

时间复杂度，确定区间需要
$$
O(n^2)
$$
累加区间的值
$$
O(n)
$$
最终的时间复杂度为
$$
O(n^3)
$$
**优化1.0**

枚举每个区间的时候，我们固定了右端，然后左端从右端点不断向前移动，直到移动到指定的左端点，其实左端向前移动的过程中，我们可以顺便得出区间的累加值，

比如：数组时nums，枚举区间，[3,3]，[2,3] ，[1,3] 这三个区间时，可以在枚举区间[3,3]时计算出[3,3]的累加和比如a,那么在计算区间[2,3]时，可以在[3,3]的基础上加上nums[2]，计算出的累加和为b，枚举区间[1,3]时，可以在[2,3]的基础上加上nums[1]。

这样只需要
$$
O(n^2)
$$
复杂度就够了

**优化1.1（个人理解）**

与优化1.0不同。我们这次固定了右端，然后左端从左端点不断向后移动，直到移动到指定的右端点。

比如：数组时nums，枚举区间，[1,1]，[1,2] ，[1,3] 这三个区间时，可以在枚举区间[1,3]时计算出[1,1]的累加和比如a,那么在计算区间[1,2]时，可以在[1,1]的基础上加上nums[2]，计算出的累加和为b，枚举区间[1,3]时，可以在[1,2]的基础上加上nums[3]。

这样只需要
$$
O(n^2)
$$
复杂度就够了

**优化2.0**

从优化1.1可以看出，用


$$
O(n)
$$
的时间复杂度可以求解一个区间的最大累加和

那么现在要求解[a,x]区间，我们就无序枚举每个区间，直接采用固定右端点，然后左端从左端点不断向后移动，直到移动到指定的右端点。

那么考虑下面两个区间[a,x-1],[a,x]

如何通过[a,x-1]求解出，[a,x]？

有两种情况：

sum[a,x-1] > 0 sum[a,x] = sum[a,x-1]+a[x]

sum[a,x-1] < 0 sum[a,x] = a[x]

我们这里

由于左端点一致，我们把sum[a,x]记作 dp[x]

于是

dp方程为
$$
dp(n)= \begin{cases} dp(n-1) + num[n], & \text {$dp(n-1)$ > 0 } \\ num[n], & \text{$dp(n-1)$ < 0} \end{cases}
$$

### **动态规划概述**

#### **动态规划解题思路**

动态规划主要分为两个核心部分，一是确定「DP 状态」，二是确定「DP 转移方程」。

### **DP 状态**

「DP 状态」的确定主要有两大原则：

1. 最优子结构
2. 无后效性

### **最优子结构**

我们仍以「宝石挑选」例题来讲解这两大原则，首先是「最优子结构」。

什么是「最优子结构」？将原有问题化分为一个个子问题，即为子结构。而对于每一个子问题，其最优值均由「更小规模的子问题的最优值」推导而来，即为最优子结构。

因此「DP 状态」设置之前，需要将原有问题划分为一个个子问题，且需要确保子问题的最优值由「更小规模子问题的最优值」推出，此时子问题的最优值即为「DP 状态」的定义。

例如在「宝石挑选」例题中，原有问题是「最大连续区间和」，子问题是「以$i$为右端点的连续区间和」。并且「以 $i$ 为右端点的最大连续区间和」由「以 $i-1$ 为右端点的最大连续区间和」推出，此时后者即为更小规模的子问题，因此满足「最优子结构」原则。

由此我们才定义 DP 状态 $f[i]$ 表示子问题的最优值，即「以 $i$为右端点的最大连续区间和」。

### **无后效性**

而对于「无后效性」，顾名思义，就是我们只关心子问题的最优值，不关心子问题的最优值是怎么得到的。

仍以「宝石挑选」例题为例，我们令 DP 状态  $f[i]$ 表示「以 $i$ 为右端点的最大连续区间和」，我们只关心「以 $i$ 为右端点的区间」这个子问题的最优值，并不关心这个子问题的最优值是从哪个其它子问题转移而来。

即无论:  $f[i]$  所表示区间的左端点是什么，都不会影响后续  $f[i+1]$ 的取值。影响 $f[i+1]$取值的只有$f[i]$ 的数值大小。

那怎样的状态定义算「有后效性」呢？

我们对「宝石挑选」例题增加一个限制，即小 Q 只能挑选长度 $\leqslant k$ 的连续区间。此时若我们定义  $f[i]$表示「以 为右$i$端点的长度  的$\leqslant k$最大连续区间和」，则 $f[i+1]$ 的取值不仅取决于$f[i]$的数值，$f[i+1]$ 还取决于是$f[i]$如何得到的。

因为如果 $f[i] $ 取得最优值时区间长度  $=k$，则  $f[i+1]$ 不能从 $f[i]$ 转移得到，即 $f[i]$  的状态定义有后效性。

最后概括一下，「最优子结构」就是「DP 状态最优值由更小规模的 DP 状态最优值推出」，此处 DP 状态即为子问题。而「无后效性」就是「无论 DP 状态是如何得到的，都不会影响后续 DP 状态的取值」。

### **DP 转移方程**

有了「DP 状态」之后，我们只需要用「分类讨论」的思想来枚举所有小状态向大状态转移的可能性即可推出「DP 转移方程」。

我们继续以「宝石挑选」问题为例。

在我们定义「DP 状态」 $f[i]$  之后，我们考虑状态 $f[i]$ 如何从 $f[1]\thicksim f[i]$  这些更小规模的状态转移而来。

仔细思考可以发现，由于 $f[i]$ 表示的是连续区间的和，因此其取值只与 $f[i-1]$有关，与 $f[1] \thicksim f[i-2]$ 均无关。

我们再进一步思考， $f[i]$取值只有两种情况，一是向左延伸，包含 $f[i-1]$，二是不向左延伸，仅包含$a[i]$ ，由此我们可以得到下述「DP 转移方程」：

​														$$f[i] = max(f[i-1]+a[i])$$

注意，$i \in[1,n]$  且 $f[0] = 0$ 。

### **动态规划问题类别**

讲述完 DP 问题的解题思路后，我们来大致列举一下 DP 问题的类别。

DP 问题主要分为两大类，第一大类是 DP 类型，第二大类是 DP 优化方法。![v2-21366d47656574b928749040c6cc1888_r](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/v2-21366d47656574b928749040c6cc1888_r.jpg)

## **总结**

最后我们来总结一下 DP 问题的解题思路：

- 确定「DP 状态」

- - 符合「最优子结构」原则：DP 状态最优值由更小规模的 DP 状态最优值推出
  - 符合「无后效性」原则：状态的得到方式，不会影响后续其它 DP 状态取值



- 确定「DP 转移方程」

- - 分类讨论，细心枚举



## KMP算法

先上代码

```java
public class KMP {
    public void prefixTable(char[] pattern,int[] prefixTable,int n){
        prefixTable[0] = 0;
        int i = 1;
        int j = 0;
        while(i < n){
                if(pattern[j] == pattern[i]){
                    prefixTable[i] = j+1;
                    i++;
                    j++;
                }else{
                    if(j > 0){
                        if(prefixTable[j-1] >= 0) {
                            j = prefixTable[j-1];
                        }
                    }else{
                        i++;
                    }
                }
        }
    }

    public void movePrefixTable(int[] prefixTable,int n){
        for(int i=n-1;i>0;i--){
            prefixTable[i] = prefixTable[i-1];
        }
        prefixTable[0] = -1;
    }
    public void kmpSearch(char[] text,char[] pattern){
        int n = pattern.length;
        int[] prefiexTable = new int[n];
        prefixTable(pattern,prefiexTable,n);
        movePrefixTable(prefiexTable,n);
        int i = 0;
        int m = text.length;
        int j = 0;
        while(i<m){
            if(j == n-1 && (text[i] == pattern[j])){
                System.out.println("found text " + (i-j));
                j = prefiexTable[j];
                if(j == -1){
                    i++;j++;
                }
            }
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                j = prefiexTable[j];
                if(j == -1){
                    i++;j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String pattern = "ABABCABAA";
//        String pattern = "acacabacacabacacac";
        String text = "ABABABCABAABABABAB";
        kmp.kmpSearch(text.toCharArray(),pattern.toCharArray());
    }
}
```

暴力解法

从头比较，不一致，P向后移动一位

![image-20200831223007362](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831223007362.png?raw=true)

![image-20200831223115047](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831223115047.png?raw=true)

![image-20200831223140507](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831223140507.png?raw=true)

这里我们通过三部找到了

![image-20200831223711846](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831223711846.png?raw=true)

![image-20200831223741604](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831223741604.png?raw=true)

这里只需要两步

kmp算法里增加了next数组，使用next数组加速字符串匹配。

为什么next数组可以加速字符串匹配？

在暴力解法中，每次字符串P只向后移动一个字符。

在kmp中，在上面例子中，字符串P可以移动两个字符。

因为T[4] != P[4]，那么要移动几个字符才好？

因为P[0-3] = T[0-3]，所以如果P[0-3]有前缀串和后缀串一样，那么就可以直接把P[0-3]的前缀串和T[0-3]的后缀串对齐。（注意：这里的前缀串和后缀串长度要小于字符串本身）

那么kmp的核心问题就变成了如何求next数组？

我们观察以下字符串：

 ![image-20200831225107356](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831225107356.png?raw=true)

![image-20200831225140782](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831225140782.png?raw=true)

A很显然时0，没有长度为0的字符串了

![image-20200831225301735](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831225301735.png?raw=true)

求AB的时候 ，因为之前的A已经确定了所以next[0] = 0

next[1] = ?

求解next[i] 

1. P[next[i]] 等于 P[i]  next[i] = next[i-1] + 1
2. i-1 大于等于0 ,
3. P[next[i-1]] 等于 P[i]  next[i] = next[i-1] + 1
4. P[next[i-1]] 不等于 P[i]  让 i = next[i-1] 重复 2 3 4 直到P[next[i-1]] 等于 P[i]或者找不到 next[i] = 0

![image-20200831225750611](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831225750611.png?raw=true)

求next[4] 

1. next[4-1] = 2
2. (P[2] = A) != (P[4] = C)
3. next[2-1] = 0
4. (P[0] = A) != (P[4] = C)
5. 0 - 1 小于 0
6. 循环终止
7. next[4] = 0

![image-20200831230203991](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831230203991.png?raw=true)

求解next[8]?

1. next[8-1] = 1
2. (P[1] = B) != (P[8] = A)
3. next[1-1] = 0
4. (P[0] = A) == (P[8] = A) next[8] = next[0] + 1
5. 循环终止

通过上面求解的next数组还需要向后移动，在对前面加-1

于是最终的next就是

![image-20200831230737329](https://github.com/xumingze2014/algorithm011-class01/blob/master/img/image-20200831230737329.png?raw=true)







