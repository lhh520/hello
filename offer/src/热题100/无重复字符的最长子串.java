package 热题100;

import org.junit.Test;

import java.util.*;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int start=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                start=Math.max(start,map.get(c)+1);
            }
            map.put(c,i);
            count=Math.max(count,(i-start+1));
        }
        return count;
    }
    @Test
    public void test(){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
