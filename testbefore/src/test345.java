import org.junit.Test;

import java.util.Arrays;

public class test345 {
    public String reverseVowels(String s) {
    int left=0,right=s.length()-1;
    char[] ss=s.toCharArray();
    while (left<right)
    {
        if(check(ss[left])&&check(ss[right]))
        {
            char temp=ss[left];
            ss[left]=ss[right];
            ss[right]=temp;
            left++;
            right--;
            continue;
        }
        if(!check(ss[left]))
            left++;
        if(!check(ss[right]))
            right--;
    }

        //String fromChar = new String(new char[]{ss});
        String str= String.valueOf(ss);
        return str;

    }
    public boolean check(char a)
    {
        if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u')
            return true;
        else
            return false;
    }
    @Test
    public void test()
    {
        String s="hello";
        System.out.println(reverseVowels(s));


    }
}
