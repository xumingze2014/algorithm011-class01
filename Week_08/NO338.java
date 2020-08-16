package com.example.demo.week6;

public class NO338 {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        for(int i=1;i<=num;i++){
            dp[i] = dp[i>>1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        NO338 no338 = new NO338();
        int[] ints = no338.countBits(5);
        for(int s : ints){
            System.out.print(s);
            System.out.print(" ");
        }
    }
}
