package 代码随想录;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s){
        Map<Character,Integer>map=new HashMap<>();
        int start=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                start=Math.max(i,map.get(c)+1);//有可能是当前的值 也有可能是下一个值加1 两种情况都会移除重复的
            }
            map.put(c,i);
            count=Math.max(count,i-start+1);
        }
        return count;
    }
    public int lengthOfLongestSubstring1(String s){
        int left=0;
        int right=0;
        int count=0;
        Set<Character>set=new HashSet<>();
        for(;right<s.length();right++){
            char ch=s.charAt(right);
            while (set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            count=Math.max(count,right-left+1);
        }
        return count;
    }
    @Test
    public void test(){
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring1(s));
    }
}
