package test;

import org.junit.Test;

import java.util.Stack;

public class test150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack=new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+"))
            {
                int temp1=stack.pop();
                int temp2=stack.pop();
                stack.push(temp1+temp2);
            }
            else if(tokens[i].equals("*"))
            {
                int temp1=stack.pop();
                int temp2=stack.pop();
                stack.push(temp1*temp2);
            }
            else if(tokens[i].equals("-"))
            {
                int temp1=stack.pop();
                int temp2=stack.pop();
                stack.push(temp1-temp2);
            }
            else if(tokens[i].equals("/"))
            {
                int temp1=stack.pop();
                int temp2=stack.pop();
                stack.push(temp1/temp2);
            }
            else
                stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.peek();
    }
    @Test
    public void test()
    {
        String[] nn=new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(nn));
    }
}
