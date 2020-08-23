学习笔记

# 高级动态规划

## 找出DP方程的一个重要思路：

- 增加维度
- 字符串问题通常定义dp\[i\]\[j\]

## 增加维度的经典例题：

### 买卖股票

思路：因为需要考虑几个条件。今天是卖出状态，还是买入状态。已经交易的次数。第几天。

这里有三个条件所以定义DP方程

> dp\[i\]\[k\]\[j\]

i：第几天

k：已经交易几次

j：0 当前时卖出状态，1 当前时买如入状态

### 打家劫舍

思路：需要考虑两个事情，

1. 第i个房子
2. 第i个房子，偷还是不偷

定义dp\[i\]\[k\]

i：第i个房子

k: 1 第i个房子偷 0 第i个房子不偷



### 字符串问题通常定义dp\[i\]\[j\]

经典例题：

### 编辑距离

定义dp\[i\]\[j\] : 字符串1的前i个字符 与 字符串2的前j个字符的编辑距离

对于字符串问题通常还需要，从后往前看，就是假设前缀已经满足的情况下，这一位如何处理

对于编辑距离

- 情况一：当前位置两个字符不一致（s[i] !=s[j]）

\*\*\*\*b

\*\*\*\*a

有以下几种处理

1. 去掉 a 和 b
2. 去掉a
3. 去掉b

于是dp\[i\]\[j\] = min(d\p[i-1\]\[j-1\] ,dp\[i-1\]\[j\],dp\[i\]\[j-1\])

- 情况二：当前位置两个字符一致（s[i] ==s[j]）

这种情况dp\[i\]\[j\] = d\p[i-1\]\[j-1\]

# 高级字符串算法

## 字符串匹配算法

#### KMP

知乎上一个比较好的

https://zhuanlan.zhihu.com/p/83334559

```java
package com.example.demo.strpattern;

public class KMP {

    int kmpSearch(String s, String p)
    {
        int[] next = new int[p.length()];
        getNext(p,next);
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int pLen = p.length();
        while (i < sLen && j < pLen)
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        else
            return -1;
    }

    void getNext(String p,int[] next)
    {
        int pLen = p.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1)
        {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p.charAt(j) == p.charAt(k))
            {
                ++k;
                ++j;
                next[j] = k;
            }
            else
            {
                k = next[k];
            }
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.kmpSearch("aaaaaaab","aab"));
    }
}
```

#### Sunday

```java
package com.example.demo.strpattern;

public class Sunday {
    public static void main(String[] args) {
        String s="HERE IS AEXAMPLE SIMPLE";
        String t="EXAMPLE";
        System.out.println(sunday(s, t));
    }

    private static Boolean sunday(String s, String t){
        int index_s=0;
        int index_t=0;

        while(index_s < s.length() && index_t < t.length()){
            if(t.charAt(index_t)==s.charAt(index_s)){
                index_t++;
                index_s++;
            }else{
                if(index_s + t.length() < s.length()){
                    //这里必须从右向左匹配
                    int loc = t.lastIndexOf(s.charAt(index_s + t.length()));
                    index_s = index_s + t.length() - loc;
                    index_t = 0;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
```