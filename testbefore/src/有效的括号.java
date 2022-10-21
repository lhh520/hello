import java.util.*;
public class 有效的括号 {
    public boolean isValid(String s){
        Stack<Character>stack=new Stack<>();
        int i=0;
        while (i<s.length()){
            char c=s.charAt(i);
            if(c=='{'||c==']'||c=='}'){
                stack.push(c);
            }else {
                if(c=='}'&&stack.peek()=='{'){
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
        return true;
    }
}
