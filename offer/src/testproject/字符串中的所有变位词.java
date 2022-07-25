package testproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 字符串中的所有变位词 {
    public List<Integer> findAnagrams(String s, String p){
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        int[]pp=new int[26];
        for(int i=0;i<p.length();i++){
            pp[p.charAt(i)-'a']++;
        }
        int left=0,right=p.length()-1;
        int[]ret=new int[26];
        for(int i=0;i<=right;i++){
            ret[s.charAt(i)-'a']++;
        }
        List<Integer>ans=new ArrayList<>();
        while (right<s.length()){
            if(Arrays.equals(ret,pp)){
                ans.add(left);
            }
            right++;
            if(right<s.length())
            ret[s.charAt(right)-'a']++;
            ret[s.charAt(left)-'a']--;
            left++;
        }
        return ans;
    }
}
