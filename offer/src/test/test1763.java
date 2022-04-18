package test;

import org.junit.Test;

public class test1763 {
    public String longestNiceSubstring(String s) {
    int n=s.length();
    int maxPos=0;
    int maxLen=0;
    for(int i=0;i<n;i++)
    {
        int lower=0;
        int upper=0;
        for(int j=i;j<n;j++)
        {
            if(Character.isLowerCase(s.charAt(j)))
            {
                lower|=1<<(s.charAt(j)-'a');
                System.out.println(lower);
            } else {
                upper|=1<<(s.charAt(j)-'A');
                System.out.println(upper);
            }
            if(lower==upper&&j-i+1>maxLen)
            {
                maxPos=i;
                maxLen=j-i+1;
            }
        }
    }
    return s.substring(maxPos,maxPos+maxLen);
    }
    @Test
    public void test()
    {
        String s="YazaAay";
        System.out.println(longestNiceSubstring(s));
    }
}
