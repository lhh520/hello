package test;

import org.junit.Test;

import java.util.Stack;

public class 移掉K位数字 {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        Stack<Integer>stack=new Stack<>();
        int i=0;
        for(i=0;i<num.length();i++){
            int cur=num.charAt(i)-'0';
            while (k>0&&(!stack.isEmpty())&&cur<stack.peek()){
                k--;
                stack.pop();
            }
            if(stack.isEmpty()&&cur==0)
                continue;
            stack.push(cur);
        }
        while (k>0&&!stack.isEmpty()){
            k--;
            stack.pop();
        }
        StringBuilder sb=new StringBuilder();
        for(int nn:stack){
            sb.append(nn);
         }
        return sb.length()==0?"0":sb.toString();
//        StringBuilder sb=new StringBuilder();
//        for(int nn:stack){
//            sb.append(nn);
//        }
//
//        String ans= sb.reverse().toString()+num.substring(i);
//        int mm=Integer.parseInt(ans);
//        return Integer.toString(mm);
    }
    @Test
    public void test(){
        String ss="10001";
        System.out.println(removeKdigits(ss,4));
    }
}
