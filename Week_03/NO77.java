package com.example.demo.week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NO77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        helper(1,k,n,path,result);
        return result;
    }

    public void helper(int first,int k,int n,ArrayDeque<Integer> path,List<List<Integer>> result){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=first;i<=n;i++){
            path.addLast(i);
            helper(i+1,k,n,path,result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        NO77 no77 = new NO77();
        System.out.println(no77.combine(5, 2));
    }
}
