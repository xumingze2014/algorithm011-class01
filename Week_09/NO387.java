package com.example.demo.week9;

import java.util.HashMap;
import java.util.Map;

public class NO387 {
    public int firstUniqChar(String s) {
        Map<Integer,Integer> tmp = new HashMap();
        int result = -1;
        for(int i=0;i<s.length();i++){
            tmp.put(s.charAt(i) - 'a',tmp.getOrDefault(s.charAt(i) - 'a',0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(tmp.get(s.charAt(i) - 'a') == 1){
                return i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NO387 no387 = new NO387();
        System.out.println(no387.firstUniqChar("leetcode"));
        System.out.println(no387.firstUniqChar("loveleetcode"));
    }
}
