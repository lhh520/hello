package test;

import org.junit.Test;

public class test2000 {
    public String reversePrefix(String word, char ch) {
    int i=0;
    for(i=0;i<word.length();i++)
    {
        if(ch==word.charAt(i))
        {
            break;
        }
    }
    if(i>=word.length())
        return word;
    String temp=word.substring(0,i+1);
    StringBuilder sb=new StringBuilder();
    for(int j=0;j<temp.length();j++)
    {
        sb.append(temp.charAt(j));
    }
    sb.reverse();
    for(int j=i+1;j<word.length();j++)
    {
        sb.append(word.charAt(j));
    }
    return sb.toString();
    }
    @Test
    public void test()
    {
        System.out.println(reversePrefix("abcdefd",'d'));
    }
}
