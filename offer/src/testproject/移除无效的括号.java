package testproject;

import org.junit.Test;

import java.util.Stack;

public class 移除无效的括号 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        // 删除多余的')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
                sb.append(c);
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    balance = 0;
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        int i = sb.length() - 1;
        // 删除多余的'('
        while (balance != 0) {
            if (sb.charAt(i) == '(') {
                balance--;
                sb.deleteCharAt(i);
            }
            i--;
        }
        return sb.toString();
    }
    public String minRemoveToMakeValid1(String s){
        StringBuilder sb=new StringBuilder();
        int balance=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                balance++;
                sb.append('(');
            }else if(s.charAt(i)==')'){
                balance--;
                if(balance<0){
                    balance=0;
                }else {
                    sb.append(s.charAt(i));
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        //
        int i=sb.length()-1;
        while (balance!=0){
            if(sb.charAt(i)=='('){
                balance--;
                sb.deleteCharAt(i);
            }
            i--;
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String s="))((";
        System.out.println(minRemoveToMakeValid1(s));
    }
}
