package testproject;

import org.junit.Test;

import java.util.Stack;

public class 括号的分数 {
    public int scoreOfParentheses(String s) {
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                //分两种情况 如果左方直接就是（
                if(stack.peek()=='('){
                    stack.pop();
                    stack.push('1');
                }else {
                    int num=0;
                    while (stack.peek()!='('){
                        if(stack.peek()!='('){
                        int cur=stack.peek()-'0';
                        num+=cur;}
                        stack.pop();
                    }
                    stack.pop();
                    char cc= (char) (2*num+'0');
                    stack.push(cc);
                }
            }
        }
        int ans=0;
        for(int num:stack){
            ans+=num-'0';
        }
        return ans;
    }
    @Test
    public void test(){
        String ss="(()(()))";
        System.out.println(scoreOfParentheses(ss));
    }
}
