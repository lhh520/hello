package testproject;

import org.junit.Test;

import java.util.Stack;

public class 后缀表达式 {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("+")&&!tokens[i].equals("-")&&!tokens[i].equals("*")&&!tokens[i].equals("/")){
                stack1.push(Integer.parseInt(tokens[i]));
            }else {
                int a=stack1.pop();
                int b=stack1.pop();
                if(tokens[i].equals("+")){
                    stack1.push(a+b);
                }else if(tokens[i].equals("*")){
                    stack1.push(a*b);
                }else if(tokens[i].equals("/")){
                    stack1.push(b/a);
                }else {
                    stack1.push(b-a);
                }
            }
        }
        return stack1.peek();
    }
    @Test
    public void test(){
        String[] tokens =new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
}
