package hot100;
import org.junit.Test;

import java.util.*;
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int left=0,right=0,max=0;
        while (right<s.length()){
            //窗口收缩
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max=Math.max(max,right-left+1);
            right++;

        }
        return max;
    }
    //
    public int lengthOfLongestSubstring1(String s) {
        Set<Character>set=new HashSet<>();
        int left=0,right=0,max=0;
        while (right<s.length()){
            set.add(s.charAt(right));
            right++;

            //窗口收缩
            while (right<s.length()&&set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            max=Math.max(max,right-left);


        }
        return max;
    }
    @Test
    public void test(){
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring1(s));
    }
}
