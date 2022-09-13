package plan92.test;
import org.junit.Test;

import java.util.*;
public class 无重复最长字串 {
    public int lengthOfLongestSubstring(String s) {
         Set<Character>set=new HashSet<>();
         int left=0,right=0;
         int win=0;
         while (right<s.length()){
             //先缩小窗口
             while (!set.isEmpty()&&set.contains(s.charAt(right))){
                 set.remove(s.charAt(left));
                 left++;
             }
             set.add(s.charAt(right));
             right++;
             win=Math.max(set.size(),win);
         }
         return win;
    }
    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
