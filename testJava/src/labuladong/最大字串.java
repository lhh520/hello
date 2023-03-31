package labuladong;

import java.util.HashSet;
import java.util.Set;

public class 最大字串 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++){
            char char1 = text1.charAt(i - 1);
            for(int j=0;j<=text2.length();j++){
                char char2 = text2.charAt(i - 1);
                if(char1==char2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public  int maxSubArray(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int res=nums[0];
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=res>dp[i]?res:dp[i];
        }
        return res;
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int left=0,right=0;
        int max=0;
        while(right<s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            max=Math.max(max,set.size());
        }
        return max;
    }
}
