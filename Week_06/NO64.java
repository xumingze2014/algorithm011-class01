package com.example.demo.week5;

public class NO64 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i-1<0 && j-1 >= 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if(i-1>=0 && j-1 < 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else if(i-1<0 && j-1 <= 0){
                    dp[i][j] = grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

//    public void helper(int maxX,int maxY,int[][] grid){
//        if(x==maxX && y==maxY) {
//            presum = Math.min(presum,sum) == -1 ? sum:presum;
//            return;
//        }
//
//        //向下
//        if(x==maxX){
//            sum += grid[x][++y];
//            helper(maxX,maxY,grid);
//            sum -= grid[x][y];
//            y--;
//        }else if(y==maxY){
//            //向右
//            sum += grid[++x][y];
//            helper(maxX,maxY,grid);
//            sum -= grid[x][y];
//            x--;
//        }else{
//            sum += grid[x][++y];
//            helper(maxX,maxY,grid);
//            sum -= grid[x][y];
//            y--;
//            sum += grid[++x][y];
//            helper(maxX,maxY,grid);
//            sum -= grid[x][y];
//            x--;
//        }
//    }

    public static void main(String[] args) {
        NO64 no64 = new NO64();
        System.out.println(no64.minPathSum(new int [][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        }));
    }
}
