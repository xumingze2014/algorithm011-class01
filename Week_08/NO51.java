package com.example.demo.week8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NO51 {
    int size = 0;
    int n = 0;
    List<List<String>> result = new ArrayList<>();
    public void helper(int row,int l,int r,ArrayDeque<Integer> path){
        if(row == size){
            ArrayList<String> objects = new ArrayList<>();

            for(Integer num : path){
                StringBuilder stringBuilder = new StringBuilder();
                for(int i=0;i<n;i++){
                    if(1 == ((num>>i) & 1) ){
                        stringBuilder.append("Q");
                    }else{
                        stringBuilder.append(".");
                    }
                }
                objects.add(stringBuilder.toString());
            }
            result.add(objects);
            return;
        }
        int pow = size & (~(row|l|r));

        while (pow !=0) {
            int p = pow & (-pow);
            pow -= p;
            path.addLast(p);
            helper(row|p,(l|p)<<1,(r|p)>>1,path);
            path.removeLast();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        size = (1<<n) - 1;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        helper(0,0,0,path);
        return result;
    }

    public static void main(String[] args) {
        NO51 no51 = new NO51();
        System.out.println(no51.solveNQueens(4));
    }
}
