package back;
import org.junit.Test;

import java.util.*;
public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        Set<Character>set=new HashSet<>();
        int left=0,right=0;
        int ret=0;
        while (right<s.length()){
            while (!set.isEmpty()&&set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            ret=Math.max(ret,set.size());
        }
        return ret;
    }
    @Test
    public void test(){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
