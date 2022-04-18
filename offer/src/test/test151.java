package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test151 {
    public String reverseWords(String s) {
        s = s.trim();
    String[]temp=s.split(" ");
    StringBuilder sb=new StringBuilder();
    for (int i = temp.length-1; i >=0; i--) {
        if(temp[i]!=" ")
        sb.append(temp[i]);
        if(i!=0)
        sb.append(" ");
    }


        System.out.println(temp.length);
        System.out.println(Arrays.toString(temp));
        return sb.toString();
    }
    public String reverseWords1(String s)
    {
      s=s.trim();
      List<String>wo=Arrays.asList(s.split("\\s+"));
      Collections.reverse(wo);
      return String.join(" ",wo);
    }
    @Test
    public void test()
    {
        String s= "  hello world  ";
        System.out.println(reverseWords(s));
    }
}
