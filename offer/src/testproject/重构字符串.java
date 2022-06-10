package testproject;

import org.junit.Test;

import java.util.HashMap;

public class 重构字符串 {
    public String reorganizeString(String s) {
        int[]chars=new int[26];
        int Indexmax=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)-'a']++;
        }
        for(int i=0;i<chars.length;i++){
            if(max<chars[i]){
                Indexmax=i;
                max=chars[i];
            }
        }
        if(max>(s.length()-max+1)){
            return "";
        }
        System.out.println(1);
        char[]res=new char[s.length()];
        int index=0;
        while (chars[Indexmax]-->0){
            res[index]= (char) (Indexmax+'a');
            index=index+2;
        }
        //将剩下的进行填充
        for(int i=0;i<chars.length;i++){
            while (chars[i]-->0){
                if(index>=s.length()){
                    index=1;
                }
                res[index]= (char) (i+'a');
                index=index+2;
            }

        }
        return new String(res);
    }
    @Test
    public void test(){
        String s = "vvvlo";
        System.out.println(reorganizeString(s));
    }
}
