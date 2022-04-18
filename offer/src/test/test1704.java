package test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class test1704 {
    public boolean halvesAreAlike(String s) {
    String s1=s.substring(0,s.length()/2);
    String s2=s.substring(s.length()/2,s.length());
    //（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'
    Set<Character>set=new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    set.add('A');
    set.add('E');
    set.add('I');
    set.add('O');
    set.add('U');
    int count1=0,count2=0;
    for(int i=0;i<s1.length();i++)
    {
        if(set.contains(s1.charAt(i)))
            count1++;
        if(set.contains(s2.charAt(i)))
            count2++;
    }
    return count1==count2;
    }
    @Test
    public void test()
    {
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }
}
