package hot100;

import java.util.*;

public class 括号匹配 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(stack.isEmpty()||str.charAt(i)=='['||str.charAt(i)=='{'||str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }else {
                if(str.charAt(i)==']'&&stack.peek()=='['){
                    stack.pop();
                }else if(str.charAt(i)=='}'&&stack.peek()=='{'){
                    stack.pop();
                }else if(str.charAt(i)==')'&&stack.peek()=='('){
                    stack.pop();
                }else {
                    System.out.println(false);
                    return;
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
