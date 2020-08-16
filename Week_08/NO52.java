package com.example.demo.week8;

public class NO52 {
    int size = 0;
    int count = 0;

    public void helper(int row,int l,int r){
        if(row == size){
            count++;
            return;
        }
        int pow = size & (~(row|l|r));

        while (pow !=0) {
            int p = pow & (-pow);
            pow -= p;
            helper(row|p,(l|p)<<1,(r|p)>>1);
        }
    }

    public int totalNQueens(int n) {
        size = (1<<n) - 1;
        helper(0,0,0);
        return count;
    }

    public static void main(String[] args) {
        NO52 no52 = new NO52();
        System.out.println(no52.totalNQueens(4));
    }
}
