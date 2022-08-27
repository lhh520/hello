package face;
import org.junit.Test;

import java.util.*;
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s){
        Set<Character>set=new HashSet<>();
        int len=0;
        int left=0,right=0;
        while (right<s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
    @Test
    public void test(){
        String ss= "abcabcbb";
        System.out.println(lengthOfLongestSubstring(ss));
    }
}
