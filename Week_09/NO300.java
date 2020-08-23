package com.example.demo.week9;

public class NO300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for(int i=0;i<nums.length;i++){
            int tmp = 0;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    tmp = Math.max(tmp,dp[j]);
                }
                dp[i] = tmp + 1;
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        NO300 no300 = new NO300();
//        System.out.println(no300.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(no300.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
