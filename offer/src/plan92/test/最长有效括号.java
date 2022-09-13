package plan92.test;

import org.junit.Test;

public class 最长有效括号 {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;

        int[] dp = new int[s.length()]; // dp[i]：严格以i位置结尾，形成的有效括号子串最长长度是多少
        int max = 0; // 最终的答案
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                int preLen=dp[i-1];
                int pre=i-preLen-1;
                if(pre>=0&&s.charAt(pre)=='('){
                    dp[i]=dp[i-1]+2;
                    if(pre-1>=0){
                        dp[i]+=dp[pre-1];
                    }
                }
                max=Math.max(max,dp[i]);
            }
        }
        return max;


    }
    @Test
    public void test(){
        System.out.println(longestValidParentheses( "(()"));
    }
}
