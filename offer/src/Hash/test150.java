package Hash;

import org.junit.Test;

import java.util.Stack;

public class test150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack1=new Stack<>();
        for(String s:tokens){
            if(!s.equals("+")&&!s.equals("-")&&!s.equals("*")&&!s.equals("/")){
                stack1.push(Integer.parseInt(s));
            }else {
                int num1=stack1.pop();
                int num2=stack1.pop();
                if(s.equals("+")){
                    stack1.push(num1+num2);
                }else if(s.equals("-")){
                    stack1.push(num1-num2);
                }else if(s.equals("*")){
                    stack1.push(num1*num2);
                }else if(s.equals("/")){
                    stack1.push(num2/num1);
                }
            }
        }
        return stack1.peek();
    }
    @Test
    public void test(){
        String[] tokens=new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

}
