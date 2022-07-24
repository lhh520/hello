package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 使两字符串互为字母异位词的最少步骤数 {
    public int minSteps(String s, String t) {
        int[]s1=new int[26];
        for(int i=0;i<s.length();i++){
            s1[s.charAt(i)-'a']++;
        }
        int[]s2=new int[26];
        for(int i=0;i<t.length();i++){
            s2[t.charAt(i)-'a']++;
        }
        int count=0;
        for(int i=0;i<26;i++){
            int max=Math.max(s1[i],s2[i]);
            count=count+(max-s1[i])+(max-s2[i]);
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(minSteps( "leetcode","coats"));
    }
}
