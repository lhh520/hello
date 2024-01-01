package 新刷题;

import org.junit.Test;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='{'||c=='['||c=='('){
                stack.add(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }else if(c=='}'&&stack.peek()=='{'){
                    stack.pop();
                }else if(c==']'&&stack.peek()=='['){
                    stack.pop();
                }else if(c==')'&&stack.peek()=='('){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    @Test
    public void test(){
        String str="()";
        System.out.println(isValid(str));
    }
}
