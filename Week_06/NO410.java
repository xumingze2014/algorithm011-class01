package com.example.demo.week5;

public class NO410 {
    public int splitArray(int[] nums, int m) {
        //f[i][j] = min(f[k][j-1],sub(k+1~i))
        int[][] f = new int[nums.length+1][m+1];
        for(int i=0;i<f.length;i++){
            for(int j=0;j<f[i].length;j++){
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] sub = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sub[i+1] += sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }

        return f[nums.length][m];
    }

    public static void main(String[] args) {
        NO410 no410 = new NO410();
        System.out.println(no410.splitArray(new int[]{7,2,5,10,8}, 2));
    }
}
