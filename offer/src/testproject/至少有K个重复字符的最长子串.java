package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        if(s.length()<k) return 0;
        Map<Character,Integer>counter=new HashMap<>();
        for(int i=0;i<s.length();i++){
            counter.put(s.charAt(i),counter.getOrDefault(s.charAt(i),0)+1);
        }
        for(char c: counter.keySet()){
            if(counter.get(c)<k){
                int res=0;
                for(String t:s.split(String.valueOf(c))){
                    res=Math.max(res,longestSubstring(t,k));
                }
                return res;
            }
        }
        return s.length();
    }
    @Test
    public void test(){
        String s = "aaabb";
        System.out.println(longestSubstring(s,3));
    }
}

