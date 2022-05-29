package testproject;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> stack=new HashSet<>();
        char[]cc=s.toCharArray();
        int maxLen=Integer.MAX_VALUE;
        int i=0,j=0;
        int ans=0;
        while (j<cc.length){
            //栈为空，则应该直接插入
            if(stack.isEmpty()){
                stack.add(cc[j]);
                j++;
                continue;
            }
            while(stack.contains(cc[j])){
                i++;
                stack.remove(cc[i]);
            }
            if(j<cc.length&&(!stack.contains(cc[j]))){
                stack.add(cc[j]);
                j++;
            }
            ans=Math.max(ans,j-i);
        }
        return ans;
    }
    @Test
    public void test(){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
