package 热题100;

import org.junit.Test;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
           if(c=='('||c=='{'||c=='['){
               stack.push(c);
           }else {
               if(stack.isEmpty()){
                   return false;
               } else if(c==')'&&stack.peek()=='('){
                   stack.pop();
               }else if(c==']'&&stack.peek()=='['){
                   stack.pop();
               }else if(c=='}'&&stack.peek()=='{'){
                   stack.pop();
               }else {
                   return false;
               }
           }
        }
        return stack.isEmpty()?true:false;
    }
    @Test
    public void test(){
        String ss= "(])";
        boolean f=isValid(ss);
        System.out.println(f);
    }
}
