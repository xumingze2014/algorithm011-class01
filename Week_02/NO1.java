package com.example.demo.week2;

import java.util.HashMap;
import java.util.Map;

public class NO1 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> numsMap = new HashMap();

        for(int i=0;i<nums.length;i++){
            if(numsMap.containsKey(target - nums[i])){
                return new int[]{numsMap.get(target-nums[i]),i};
            }

            numsMap.put(nums[i],i);
        }

        return new int[0];
    }
}
