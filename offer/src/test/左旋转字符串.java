package test;

import org.junit.Test;

public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        int len=s.length();
        return s.substring(n,len)+s.substring(0,n);
    }
    @Test
    public void test(){
        String str="abcdefg";
        System.out.println(reverseLeftWords(str,2));
    }
}
