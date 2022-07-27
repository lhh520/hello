package testproject;

import org.junit.Test;

import java.util.Stack;

public class 括号的最大嵌套深度 {
    public int maxDepth(String s) {
        int depth=0;
        int cur=0;
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
                depth++;
            }
            if(s.charAt(i)==')'){
                stack.pop();
                depth--;
            }
            cur=Math.max(depth,cur);
        }
        return cur;
    }
    @Test
    public void test(){
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
}
