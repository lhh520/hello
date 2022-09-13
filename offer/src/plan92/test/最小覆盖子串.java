package plan92.test;
import java.util.*;
public class 最小覆盖子串 {
    public String minWindow(String s, String t){
        Map<Character,Integer>window=new HashMap<>();
        Map<Character,Integer>need=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int len=Integer.MAX_VALUE;
        int count=0;
        int start=0;
        while (right<s.length()){
            //窗口逐渐扩大
            char c=s.charAt(right);
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c)==window.get(c)){
                    count++;
                }
            }
            //窗口逐渐缩小
            while (count==need.size()){
                if(right-left<len){
                    len=right-left;
                    start=left;
                }
                char d=s.charAt(left);
                left++;
                if(need.containsKey(d)){
                   if(need.get(d)==window.get(d)){
                       count--;
                   }
                }
                window.put(d,window.get(d)-1);
            }


        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
