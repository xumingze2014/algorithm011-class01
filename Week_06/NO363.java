package com.example.demo.dp;

public class NO363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {

        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int l=0;l<col;l++){
            int[] rowNum = new int[row];
            for (int r = l; r < col; r++) {
                for(int i=0;i<row;i++) {
                    rowNum[i] = rowNum[i] + matrix[i][r];
                }
                max = Math.max(helper(rowNum,k),max);
                if(max == k){
                    return k;
                }
            }
        }


        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public int helper(int[] rowNum,int k){
        int[] dp = new int[rowNum.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<rowNum.length;i++){
            if(i==0){
                dp[i] = rowNum[i];
            }else{
                if(dp[i-1] > 0){
                    dp[i] = dp[i-1] + rowNum[i];
                }else{
                    dp[i] = rowNum[i];
                }
            }
            max = Math.max(dp[i],max);
        }
        if(max <= k){
            return max;
        }
        int max1 = Integer.MIN_VALUE;
        for(int i=0;i<rowNum.length;i++){
            int sum = 0;
            for(int j=i;j<rowNum.length;j++){
                sum += rowNum[j];
                if(sum <= k){
                    max1 = Math.max(sum,max1);
                }
                if(max1 == k){
                    return k;
                }
            }
        }

        return max1;
    }

    public static void main(String[] args) {
        NO363 no363 = new NO363();
//        System.out.println(no363.maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
        /**
         * [[5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4]]
         * 8
         */
//        System.out.println(no363.maxSumSubmatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 8));
//        System.out.println(no363.maxSumSubmatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 3));
        /**
         * [27,5,-20,-9,1,26,1,12,7,-4,8,7,-1,5,8],[16,28,8,3,16,28,-10,-7,-5,-13,7,9,20,-9,26],[24,-14,20,23,25,-16,-15,8,8,-6,-14,-6,12,-19,-13],[28,13,-17,20,-3,-18,12,5,1,25,25,-14,22,17,12],[7,29,-12,5,-5,26,-5,10,-5,24,-9,-19,20,0,18],[-7,-11,-8,12,19,18,-15,17,7,-1,-11,-10,-1,25,17],[-3,-20,-20,-7,14,-12,22,1,-9,11,14,-16,-5,-12,14],[-20,-4,-17,3,3,-18,22,-13,-1,16,-11,29,17,-2,22],[23,-15,24,26,28,-13,10,18,-6,29,27,-19,-19,-8,0],[5,9,23,11,-4,-20,18,29,-6,-4,-11,21,-6,24,12],[13,16,0,-20,22,21,26,-3,15,14,26,17,19,20,-5],[15,1,22,-6,1,-9,0,21,12,27,5,8,8,18,-1],[15,29,13,6,-11,7,-6,27,22,18,22,-3,-9,20,14],[26,-6,12,-10,0,26,10,1,11,-10,-16,-18,29,8,-8],[-19,14,15,18,-10,24,-9,-7,-19,-14,23,23,17,-5,6]]
         * -100
         */
//        System.out.println(no363.maxSumSubmatrix(new int[][]{{27,5,-20,-9,1,26,1,12,7,-4,8,7,-1,5,8},{16,28,8,3,16,28,-10,-7,-5,-13,7,9,20,-9,26},{24,-14,20,23,25,-16,-15,8,8,-6,-14,-6,12,-19,-13},{28,13,-17,20,-3,-18,12,5,1,25,25,-14,22,17,12},{7,29,-12,5,-5,26,-5,10,-5,24,-9,-19,20,0,18},{-7,-11,-8,12,19,18,-15,17,7,-1,-11,-10,-1,25,17},{-3,-20,-20,-7,14,-12,22,1,-9,11,14,-16,-5,-12,14},{-20,-4,-17,3,3,-18,22,-13,-1,16,-11,29,17,-2,22},{23,-15,24,26,28,-13,10,18,-6,29,27,-19,-19,-8,0},{5,9,23,11,-4,-20,18,29,-6,-4,-11,21,-6,24,12},{13,16,0,-20,22,21,26,-3,15,14,26,17,19,20,-5},{15,1,22,-6,1,-9,0,21,12,27,5,8,8,18,-1},{15,29,13,6,-11,7,-6,27,22,18,22,-3,-9,20,14},{26,-6,12,-10,0,26,10,1,11,-10,-16,-18,29,8,-8},{-19,14,15,18,-10,24,-9,-7,-19,-14,23,23,17,-5,6}},
//                -100));
        /**
         * [[2,2,-1]]
         * 0
         */
//        System.out.println(no363.maxSumSubmatrix(new int[][]{{2,2,-1}}, 0));
        System.out.println(no363.maxSumSubmatrix(new int[][]{{2,2,-1}}, 0));
    }
}
