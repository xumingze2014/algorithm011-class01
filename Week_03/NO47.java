package com.example.demo.week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NO47 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        helper(nums,nums.length,path,used,result);
        return result;
    }

    public void helper(int[] nums, int len, Deque<Integer> path,boolean[] used,List<List<Integer>> result ){
        if(path.size() == len){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(used[i]) {
                continue;
            }
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            helper(nums,len,path,used,result);

            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        NO47 no46 = new NO47();
//        System.out.println(no46.permute(new int[]{1, 2, 3}));
        System.out.println(no46.permute(new int[]{1, 1, 2}));
    }

}
