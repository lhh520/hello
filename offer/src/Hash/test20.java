package Hash;

import org.junit.Test;

import java.util.Stack;

public class test20 {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else {
                char c=s.charAt(i);
                if(c=='{'||c=='('||c=='['){
                    stack.push(c);
                }else if(c=='}'){
                    if(stack.peek()!='{')
                        return false;
                    else
                        stack.pop();
                }else if(c==']'){
                    if(stack.peek()!='[')
                        return false;
                    else
                        stack.pop();
                }else {
                    if(stack.peek()!='(')
                        return false;
                    else
                        stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
    @Test
    public void test(){
        String s= "()";
        System.out.println(isValid(s));
    }
}
