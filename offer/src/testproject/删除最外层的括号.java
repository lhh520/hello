package testproject;

import org.junit.Test;

import java.util.Stack;

public class 删除最外层的括号 {
    public String removeOuterParentheses(String s) {
        Stack<Character>stack1=new Stack<>();
        Stack<Character>res=new Stack<>();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('&&stack1.isEmpty()){
                stack1.push('(');//最左边的括号
            }else if(s.charAt(i)=='('){//内部括号
                stack1.push('(');
                res.push('(');
            }
            //右括号
            if(s.charAt(i)==')'){
                stack1.pop();
                if(!stack1.isEmpty()){//仍然是内部括号，则直接输出
                    res.push(')');
                }
            }

            while (!res.isEmpty()){
                sb.append(res.pop());
            }

        }
        return sb.toString();
    }
    @Test
    public void test(){
        String s="(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
}
