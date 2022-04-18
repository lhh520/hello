package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test696 {
    public int countBinarySubstrings(String s) {
        List<Integer>counts=new ArrayList<>();
        int ptr=0,n=s.length();
        while (ptr<n)
        {
            char c=s.charAt(ptr);
            int count=0;
            while (ptr<n&&s.charAt(ptr)==c)
            {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans=0;
        for (int i = 0; i <counts.size(); i++) {
            ans+=Math.min(counts.get(i),counts.get(i-1));
        }
        return ans;
    }
    public int countBinarySubstrings1(String s) {
       int ptr=0,n=s.length()-1;
       List<Integer>list=new ArrayList<>();
       while (ptr<n)
       {
           char c=s.charAt(ptr);
           int count=0;
           while (ptr<n&&s.charAt(ptr)==c)
           {
               ptr++;
               count++;
           }
           list.add(count);
       }
       int ans=0;
        for (int i = 0; i <list.size(); i++) {
            ans=ans+Math.min(list.get(i),list.get(i-1));
        }
        return ans;
    }
}
