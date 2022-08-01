package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 字母移位 {
    public String shiftingLetters(String s, int[] shifts) {
        //求后缀和
        int n=shifts.length;
        long[]next=new long[n+1];
        long du=0;
        for(int i=n-1;i>=0;i--){
            du=next[i+1]+shifts[i];
            next[i]=du;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            long c=s.charAt(i)-'a';
            c=(c+next[i])%26;
            sb.append((char)(c+'a'));
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String s = "abc";
        int[]shifts =new int[]{3,5,9};
        System.out.println(shiftingLetters(s,shifts));
    }
}
