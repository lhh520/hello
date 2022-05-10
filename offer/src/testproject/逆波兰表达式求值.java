package testproject;

import org.junit.Test;

import java.util.Stack;

public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int n1=stack.pop();
                int n2=stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(n2+n1);
                }else if(tokens[i].equals("-")){
                    stack.push(n2-n1);
                }
                else if(tokens[i].equals("*")){
                    stack.push(n2*n1);
                } else if(tokens[i].equals("/")){
                    stack.push(n2/n1);
                }
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }

        }
        return stack.pop();
    }
    @Test
    public void test(){
        String[]strs=new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(strs));
    }
}
