package labuladong;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int left=0,right=0;
        int ret=0;
        while (right<s.length()){
            //先缩小窗口
            while (!set.isEmpty()&&set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            ret=Math.max(ret,set.size());
            right++;

        }
        return ret;
    }
    @Test
    public void test(){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
