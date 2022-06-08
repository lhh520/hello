package testproject;

import org.junit.Test;

import java.util.Stack;

public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        Stack<Integer>stack=new Stack<>();
        int max=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
    @Test
    public void test(){
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }
}
