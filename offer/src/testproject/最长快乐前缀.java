package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 最长快乐前缀 {
    public String longestPrefix(String s) {
        List<String>list=new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            list.add(s.substring(0,i+1));
        }
        System.out.println(list);
        for(int i=1;i<s.length();i++){
            String ss=s.substring(i,s.length());
            //System.out.println(ss);
            if(list.contains(ss)){
                return ss;
            }
        }
        return "";
    }
    //KMP算法
    public String longestPrefix1(String s){
        int n=s.length();
        int[]next=new int[n];
        int i=1;
        int now=0;
        //最大公共前后缀
        while (i<n){
            if(s.charAt(i)==s.charAt(now)){
                now++;
                next[i++]=now;
            }else if(now==0){
                i++;
            }else {
                now=next[now-1];
            }
        }
        return next[n-1]==0?"":s.substring(0,next[n-1]);
    }
    @Test
    public void test(){
        String s="ababab";
        System.out.println(longestPrefix(s));
    }
}
