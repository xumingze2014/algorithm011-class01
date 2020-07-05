package com.example.demo.week2;

import java.util.*;

/**
 * 前 K 个高频元素
 */
public class NO347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                ((o1, o2) -> map.get(o1) - map.get(o2))
        );
        for(int num : map.keySet()){
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }
        int [] result = new int[heap.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
