import org.junit.Test;

import java.util.Arrays;

public class test541
{
    public String reverseStr(String s, int k)
    {  char[]chars=s.toCharArray();
       for(int i=0;i<chars.length;i=i+2*k)
       {
           reverse(chars,i,Math.min(i+k,chars.length)-1);
       }
       return new String(chars);
    }
    public void reverse(char[]chars,int s,int e)
    {
        while(s<e)
        {
            char temp=chars[s];
            chars[s]=chars[e];
            chars[e]=temp;
            s++;
            e--;
        }
    }
    @Test
    public void test()
    {   //s = "abcdefg", k = 2
         String ans="abcdefg";
         int k=2;

        System.out.println(reverseStr(ans,k));
    }
}

