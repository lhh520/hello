package 代码随想录二刷.栈与队列;

import org.junit.Test;

import java.util.Stack;

public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(stack.isEmpty()||c!=stack.peek()){
                stack.push(c);
                continue;
            }
            if(c==stack.peek()){
                stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
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
