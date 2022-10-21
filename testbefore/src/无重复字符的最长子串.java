import java.util.*;
public class 无重复字符的最长子串 {
    Set<Character>set=new HashSet<>();
    int len=0;
    public int lengthOfLongestSubstring(String s){
        int left=0,right=0;
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
}
