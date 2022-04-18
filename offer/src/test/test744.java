package test;

import org.junit.Test;

public class test744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int[]temp=new int[26];
        char ans='0';
        for (int i = 0; i < letters.length; i++) {
            temp[letters[i]-'a']++;
        }
        int ta=target-'a';
        int flag=0;
        for(int i=ta+1;i<26;i++)
        {
            if(temp[i]!=0)
            {
                ans= (char) ('a'+i);
                flag=1;
                return ans;
            }
        }
        if(flag==0)
        {
            for(int i=0;i<ta+1;i++)
            {
                if(temp[i]!=0)
                {
                    ans= (char) ('a'+i);
                    return ans;
                }
            }
        }
        return target;
    }
    @Test
    public void test()
    {
        char[] letters=new char[]{'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters,'a'));
    }
}
