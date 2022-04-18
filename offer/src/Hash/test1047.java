package Hash;

import org.junit.Test;

import java.util.Stack;

public class test1047 {
    public String removeDuplicates(String s) {
        Stack<Character>stack=new Stack<>();
        int i=0;
        while (i<s.length()){
            if(stack.isEmpty()||stack.peek()!=s.charAt(i)){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
            i++;
        }
        StringBuffer sb=new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    @Test
    public void test(){
        String s="abbaca";
        System.out.println(removeDuplicates(s));
    }
}
