import org.junit.Test;

import java.util.*;
public class 无重复字符的最长子串2 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int left=0,right=0;
        int len=0;
        while (right<s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            len=Math.max(len,set.size());

        }
        return len;
    }
    @Test
    public void test(){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
