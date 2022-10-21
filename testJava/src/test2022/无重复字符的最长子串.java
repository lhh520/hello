package test2022;
import java.util.*;
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s){
        Set<Character>set=new HashSet<>();
        int left=0,right=0;
        int len=0;
        while (right<s.length()){
            while (left<right&&set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            len=Math.max(len,set.size());
        }
        return len;
    }
    //
    public int lengthOfLongestSubstring1(String s){
        Set<Character>set=new HashSet<>();
        int left=0,right=0;
        int ret=0;
        while (right<s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            ret=Math.max(ret,set.size());
        }
        return ret;
    }
}
