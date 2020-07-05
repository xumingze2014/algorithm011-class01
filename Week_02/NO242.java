package com.example.demo.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 */
public class NO242 {
    public boolean isAnagram(String s, String t) {

        if(s == t || s.equals(t)){
            return true;
        }

        Map<String,Integer> tmp = new HashMap();

        for(String ss : s.split("")){
            tmp.put(ss,tmp.getOrDefault(ss,0) + 1);
        }

        for(String ss : t.split("")){
            tmp.put(ss,tmp.getOrDefault(ss,0) - 1);
        }

        for(String ss : tmp.keySet()){
            if(tmp.getOrDefault(ss,0) != 0){
                return false;
            }
        }

        return true;

    }
}
