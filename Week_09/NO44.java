package com.example.demo.week5;

import java.util.HashMap;
import java.util.Map;

public class NO44 {
    Map<String,Boolean> tmp = new HashMap<>();
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        return helper(0,0,sChars,pChars);
    }

    private boolean helper(int i,int j,char[] sChars,char[] pChars){
        if(tmp.get(i+"_"+j) != null){
            return tmp.get(i+"_"+j);
        }
        if(j == pChars.length){
            if(i== sChars.length){
                tmp.put(i+"_"+j,true);
                return true;
            }else{
                tmp.put(i+"_"+j,false);
                return false;
            }
        }

        boolean isMatch = i<sChars.length && (sChars[i] == pChars[j] || pChars[j] == '?');

        if(pChars[j] == '*'){
            boolean result =  helper(i,j+1,sChars,pChars) || i<sChars.length  && (helper(i+1,j+1,sChars,pChars) || helper(i+1,j,sChars,pChars));
            tmp.put(i+"_"+j,result);
            return result;
        }

        boolean result = isMatch && helper(i+1,j+1,sChars,pChars);
        tmp.put(i+"_"+j,result);
        return result;
    }

    public static void main(String[] args) {
        NO44 no44 = new NO44();
//        System.out.println("aa a false");
//        System.out.println(no44.isMatch("aa", "a"));
//        System.out.println();
//
//        System.out.println("aa * true");
//        System.out.println(no44.isMatch("aa", "*"));
//        System.out.println();
//
//        System.out.println("cb ?a false");
//        System.out.println(no44.isMatch("cb", "?a"));
//        System.out.println();

//        System.out.println("adceb *a*b true");
//        System.out.println(no44.isMatch("adceb", "*a*b"));
//        System.out.println();

//        System.out.println("acdcb a*c?b false");
//        System.out.println(no44.isMatch("acdcb", "a*c?b"));
//        System.out.println();
    }
}
