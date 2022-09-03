package plan92;
import org.junit.Test;

import java.util.*;
public class 无重复最长字串 {
    public int lengthOfLongestSubstring(String s){
        //滑动窗口 + Set
        Set<Character>set=new HashSet<>();
        int left=0,right=0;
        int sz=0;
        while (right<s.length()){
            while (!set.isEmpty()&&set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            sz=Math.max(sz,right-left);
        }
        return sz;
    }
    @Test
    public void test(){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
