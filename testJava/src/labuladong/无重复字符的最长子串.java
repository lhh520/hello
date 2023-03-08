package labuladong;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        //char[]chars=s.toCharArray();
        Set<Character> set=new HashSet<>();
        int left=0,right=0;
        int max=0;
        while (right<s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            right++;
            max=Math.max(max,set.size());
        }
        return max;
    }
}
