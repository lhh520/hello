package hot100;
import java.util.*;
public class 最小覆盖子串 {
    //滑动窗口
    public String minWindow(String s, String t){
        Map<Character,Integer>window=new HashMap<>();
        Map<Character,Integer>need=new HashMap<>();
        for(int i=0;i<t.length();i++){
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        int left=0,right=0;
        int count=0,start=0;
        int len=Integer.MAX_VALUE;
        while (right<s.length()){
            char c=t.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,need.getOrDefault(c,0)+1);
            }
            if(need.get(c).equals(window.get(c))){
                count++;
            }
            while (need.size()==count){
                if(right-left<len){
                    len=right-left;
                    start=left;
                }
                char d=s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        count--;
                    }
                }
                window.put(d,window.get(d)-1);
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
