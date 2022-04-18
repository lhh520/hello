package test;

import java.util.Stack;

public class test1678 {
    public static String interpret(String command) {
    StringBuilder sb=new StringBuilder();
    Stack<Character>stack=new Stack<>();
    for(int i=0;i<command.length();i++)
    {
        char c=command.charAt(i);
        if(c=='G')
            sb.append('G');
        if(c=='(')
            stack.push('(');
        if(c==')')
        {
            stack.pop();
            if(command.charAt(i-1)=='(')
                sb.append('o');
            else
                sb.append("al");
        }
    }
    return sb.toString();
    }

    public static void main(String[] args) {
        String commans="G()(al)";
        System.out.println(interpret(commans));
    }
}
