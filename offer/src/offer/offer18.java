package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class offer18 {
    public boolean isPalindrome(String s) {
        List<Character>list=new ArrayList<>();
        s.replaceAll(" ","");
        for(int i=0;i<s.length();i++)
        {   char temp=s.charAt(i);
            if(temp>='A'&&temp<='Z'||temp>='a'&&temp<='z')
            {if(temp>='A'&&temp<='Z')
            list.add(Character.toLowerCase(temp));
            else
                list.add(temp);}
        }
        System.out.println(list.toString());
        List<Character>list1=new ArrayList<>(list);
        Collections.reverse(list);
        System.out.println(list1.toString());

       for(int i=0;i<list.size();i++)
       {
           if(list.get(i)!=list1.get(i))
               return false;
       }
            return true;

    }
    public boolean isPalindrome1(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !check(s.charAt(l))) l++;
            while (l < r && !check(s.charAt(r))) r--;
            if (l < r && !isEquals(s.charAt(l), s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
    public boolean check(char c) { //检测字符c是否为数字或字母
        return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9';
    }
    public boolean isEquals(char a, char b) { //忽略大小写比较两个字符
        if ('A' <= a && a <= 'Z') a = (char)(a + 32);
        if ('A' <= b && b <= 'Z') b = (char)(b + 32);
        return a == b;
    }
    @Test
    public void test()
    {
        String s = "OP";
        boolean aa=isPalindrome1(s);
        System.out.println(aa);
    }
}
