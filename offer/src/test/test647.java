package test;

import org.junit.Test;

public class test647 {
    public int countSubstrings(String s) {
        //转字符数组
        char[] chars = s.toCharArray();
        //求子串
        int count=0;
        for(int i = 0; i < chars.length ; i++)
        {
            for(int j = i+1; j < chars.length+1 ; j++) {
                String temp=s.substring(i,j);
                if(check(temp))
                  count++;
            }
        }
       return count;
    }
    public boolean check(String s)
    {
        for(int i=0;i<s.length()/2;i++)
        {
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
    @Test
    public void test()
    {
        String s = "aaa";
        int ans=countSubstrings(s);
        System.out.println(ans);
    }
}
