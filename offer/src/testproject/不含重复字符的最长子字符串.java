package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 不含重复字符的最长子字符串 {
    public int lengthOfLongestSubstring(String s) {
        //最长的字串 滑动窗口
        int len=0;
        Set<Character> set=new HashSet<>();
        int left=0,right=0;
        int max=0;
        while (right<s.length()){
            //窗口扩大
            char c=s.charAt(right);
            while (set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            len=right-left+1;
            max=Math.max(len,max);
            right++;
        }
        return max;
    }
    @Test
    public void test(){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
