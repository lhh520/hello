package test;

import org.junit.Test;

public class test859 {
    public boolean buddyStrings(String s, String goal) {
    if(s.length()!=goal.length())
        return false;
    if(s.equals(goal))
    {
        int[]count=new int[26];
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(count[i]%2==0&&count[i]>0)
                return true;
        }
        return false;
    }
    else
    {
        int first=-1,second=-1;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=goal.charAt(i))
            {
                if(first==-1)
                    first=i;
                else if(second==-1)
                    second=i;
                else
                    return false;

            }

        }
        if(first!=-1&&second!=-1&&s.charAt(first)==goal.charAt(second)&&s.charAt(second)==goal.charAt(first))
            return true;
    }
    return false;
    }
    @Test
    public void test()
    {
        String s = "ab", goal = "ab";
        System.out.println(buddyStrings(s,goal));
    }
}
