package test;

import org.junit.Test;

import java.util.Stack;

public class test682 {
    public int calPoints(String[] ops) {
        int ans=0;
        //System.out.println(1);
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<ops.length;i++)
        {
            if(ops[i].equals("C"))
            {
                stack.pop();
            }
            else if(ops[i].equals("D"))
            {
                int temp=stack.peek();
                stack.push(temp*2);
            }
            else if(ops[i].equals("+"))
            {
                int temp1=stack.pop();
                int temp2=stack.pop();
                stack.push(temp2);
                stack.push(temp1);
                stack.push(temp1+temp2);
            }
            else
                stack.push(Integer.valueOf(ops[i]));
        }
        int sum=0;
        while (!stack.isEmpty())
        {
            int temp=stack.pop();
            sum=sum+temp;
        }
        return sum;
    }
    @Test
    public void test()
    {
        String[] ans=new String[]{"5","2","C","D","+"};
        int ss=calPoints(ans);
        System.out.println(ss);
    }
}
