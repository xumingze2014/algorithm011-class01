package com.example.demo.week2;

public class NO264 {
    public int nthUglyNumber(int n) {
        int r2 = 0;
        int r3 = 0;
        int r5 = 0;

        int[] dp=new int[n];
        dp[0]=1;

        for(int i = 1;i < n;i++){

            dp[i] = Math.min(Math.min(dp[r2] * 2,dp[r3] * 3),dp[r5] * 5);

            if(dp[i] == dp[r2] * 2){
                r2++;
            }
            if(dp[i] == dp[r3] * 3){
                r3++;
            }
            if(dp[i] == dp[r5] * 5){
                r5++;
            }
        }
        return dp[n-1];
    }
}
