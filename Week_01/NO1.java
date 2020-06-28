package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class NO1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> params = new HashMap();

        for(int i = 0; i < nums.length ;i++) {
            params.put(nums[i],i);
        }

        for(int i = 0; i < nums.length ;i++) {
            if(params.get(target-nums[i]) != null && params.get(target-nums[i]) != i) {
                return new int[]{i,params.get(target-nums[i])};
            }
        }

        return new int[]{};
    }
}
