package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class testyy {
    public int get(int N){
        boolean flag=true;
        if(N<0){
            N=-N;
            flag=false;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(N);
        List<Integer>list=new ArrayList<>();

        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='5'){
                //System.out.println(sb.substring(0,i-1));
                String ss=sb.substring(0,i)+sb.substring(i+1);
                //System.out.println(ss);
                list.add(Integer.parseInt(ss));
            }
        }
        Collections.sort(list);
        if(flag){
            return list.get(list.size()-1);
        }else {
            return -list.get(0);
        }
    }
    public String gets(String S){
        int left=0,right=S.length()-1;
        StringBuilder sb=new StringBuilder(S);
        char[]chars=S.toCharArray();
        //System.out.println(sb.toString());
        while (left<right){
            char c=chars[left];
            char c1=chars[right];
            if(c=='?'&&c1=='?'){
                chars[left]='a';
                chars[right]='a';
            }else if(c=='?'){
                chars[left]=c1;
            }else if(c1=='?'){
                chars[right]=c;
            }else {
                return "NO";
            }
            left++;
            right--;
        }

        return String.valueOf(chars);
    }
    @Test
    public void test(){
        int N=-5859;
        System.out.println(gets("?a?"));

    }
}
