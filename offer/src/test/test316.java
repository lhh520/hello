package test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class test316 {
    public String removeDuplicateLetters(String s) {
        Set<Character>set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <s.length(); i++) {
            if(set.add(s.charAt(i)))
                sb.append(s.charAt(i));
            else
            {
                String s1=sb.toString();
                StringBuilder sb2=new StringBuilder();
                sb2=sb;
                int index=s1.indexOf(s.charAt(i));
                sb2.deleteCharAt(index);
                sb2.append(s.charAt(i));
                String s2=sb2.toString();
                if(s1.compareTo(s2)>0)
                    sb=sb2;
            }
        }
        return sb.toString();
    }
    @Test
    public void test()
    {
        String s="bcabc";
        System.out.println(removeDuplicateLetters(s));
    }
}
