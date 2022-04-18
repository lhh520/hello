package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test241 {
    public List<Integer> diffWaysToCompute(String expression) {
       List<Integer>list=new ArrayList<>();
       int len=expression.length();
       int start=0;
       for(start=0;start<len;start++)
       {
           if(Character.isDigit(expression.charAt(start)))
               continue;
           else
               break;
       }
       if(start==len)
           list.add(Integer.parseInt(expression));
        for (int i = start; i <len; i++) {
            if(Character.isDigit(expression.charAt(i)))
                continue;
            char op=expression.charAt(i);
            List<Integer>left=diffWaysToCompute(expression.substring(0,i));
            List<Integer>right=diffWaysToCompute(expression.substring(i+1,len));
            for(int j:left)
            {
                for(int k:right)
                {
                    if(op=='+')list.add(j+k);
                    else
                        if(op=='-')list.add(j-k);
                    else if(op=='*') list.add(j+k);
                }
            }
        }
        return list;
    }
    @Test
    public void test()
    {

    }
}
