package 代码随想录二刷.数组;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串 {
    public String minWindow(String s, String t){
        Map<Character,Integer>need=new HashMap<>();
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        Map<Character,Integer>window=new HashMap<>();
        int l=0,r=0,len=Integer.MAX_VALUE;
        int count=0;
        int start=0;
        while (r<s.length()){
            //窗口缩小
            char c=s.charAt(r);
            r++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c)==need.get(c)){
                    count++;
                }
            }
            while (count==need.size()){
                if(r-l<len){
                    len=r-l;
                    start=l;
                }
                char d=s.charAt(l);
                l++;
                if(need.containsKey(d)){
                    count--;
                }
                window.put(d,window.get(d)-1);
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
