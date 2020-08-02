package com.example.demo.dp;

public class NO91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int[] dp = new int[s.length()];
        if(s.charAt(0) == '0'){
            dp[0] = 0;
        }else{
            dp[0] = 1;
        }

        for(int i=1;i<dp.length;i++){
            if(s.charAt(i-1) == '0'){
                if(s.charAt(i) == '0'){
                    return 0;
                }else {
                    if(i>=2){
                        dp[i] = dp[i-2];
                    }else{
                        dp[i] = dp[i-1];
                    }
                }
            }else if(s.charAt(i-1) == '1'){
                if(s.charAt(i) == '0'){
                    if(i>=2){
                        dp[i] = dp[i-2];
                    }else{
                        dp[i] = 1;
                    }
                }else{
                    if(i>=2){
                        dp[i] = dp[i-1] + dp[i-2];
                    }else{
                        dp[i] = dp[i-1] + 1;
                    }
                }

            }else if(s.charAt(i-1) == '2'){
                if(s.charAt(i) == '0'){
                    if(i>=2){
                        dp[i] = dp[i-2];
                    }else{
                        dp[i] = 1;
                    }
                } else if(s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                    if(i>=2){
                        dp[i] = dp[i-1] + dp[i-2];
                    }else{
                        dp[i] = dp[i-1] + 1;
                    }
                }else{
                    dp[i] = dp[i-1];
                }
            }else{
                if(s.charAt(i) == '0'){
                    return 0;
                }
                dp[i] = dp[i-1];
            }
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        NO91 no91 = new NO91();
//        System.out.println(no91.numDecodings("12"));//2
//        System.out.println(no91.numDecodings("226"));//3
//        System.out.println(no91.numDecodings("0"));//0
//        System.out.println(no91.numDecodings("1"));//1
//        System.out.println(no91.numDecodings("100"));//0
//        System.out.println(no91.numDecodings("101"));//1
//        System.out.println(no91.numDecodings("10"));//1
//        System.out.println(no91.numDecodings("110"));//1
//        System.out.println(no91.numDecodings("230"));//0
//        System.out.println(no91.numDecodings("27"));//0
//        System.out.println(no91.numDecodings("01"));//0
//        System.out.println(no91.numDecodings("101"));//0
        System.out.println(no91.numDecodings("12120"));//0
    }
}
