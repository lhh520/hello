package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test821 {
    public int[] shortestToChar(String s, char c) {
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i <s.length(); i++) {
            char temp=s.charAt(i);
            if(temp==c)
            {
                list.add(i);
            }
        }
        int[] ans=new int[s.length()];
        for (int i = 0; i <s.length(); i++) {
            int len=Integer.MAX_VALUE;
            for(int j=0;j<list.size();j++)
            {
                len=Math.min(len,Math.abs(i-list.get(j)));
            }
            ans[i]=len;
        }
        return ans;
    }
    @Test
    public void test()
    {
        String s = "loveleetcode";
        char c ='e';
        int[] ans=shortestToChar(s,c);
        System.out.println(Arrays.toString(ans));
    }
}
