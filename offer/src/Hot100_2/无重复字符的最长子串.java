package Hot100_2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
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
