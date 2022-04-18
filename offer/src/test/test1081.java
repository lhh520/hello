package test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class test1081 {
    public String smallestSubsequence(String s) {
        boolean[]vis=new boolean[26];
        int[]num=new int[26];
        //记录出了每个字符出现的次数,每次遍历都要减去1，当为0时，则后面不再出现
        //这个字符，因此，当为1时，必须将当前的字符，添加进去
        for(int i=0;i<s.length();i++)
        {
            num[s.charAt(i)-'a']++;
        }
        //用来存储所有的字符
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {   //当前的字符
            char ch=s.charAt(i);
            //
            if(!vis[ch-'a'])//当前的字符还没有添加进去
            {
                while (sb.length()>0&&sb.charAt(sb.length()-1)>ch)//字典比较小的
                {   //当前的字符后面还可以存在
                    if(num[sb.charAt(sb.length()-1)-'a']>0)
                    {
                        vis[sb.charAt(sb.length()-1)-'a']=false;//将当前的数字置为false
                        sb.deleteCharAt(sb.length()-1);
                    }
                    else
                        break;
                }
                //当前的字符可以添加进去的
                vis[ch-'a']=true;
                sb.append(ch);
            }
            //然后后面的使用的减一
            num[ch-'a']-=1;
        }
        return sb.toString();
    }

}
