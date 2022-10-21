package LCP;

import java.util.Scanner;
import java.util.*;

public class testdid {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("a");
        }
        Stack<Character>stack=new Stack<>();
        while (true){
            stack.clear();
            boolean flag=true;
            for(int i=0;i<sb.length();i++){
                if(stack.isEmpty()||stack.peek()!=sb.charAt(i)||sb.charAt(i)=='z'){
                    stack.push(sb.charAt(i));
                }else {
                    flag=false;
                    stack.pop();
                    stack.push((char)(sb.charAt(i)+1));
                }
            }
            StringBuilder sb3=new StringBuilder();
            for(char c:stack){
                sb3.append(c);
            }
            sb=sb3;
            //System.out.println(sb.toString());
            if(flag){
                break;
            }
        }

        StringBuilder sb1=new StringBuilder();
        for(char c:stack){
            sb1.append(c);
        }
        System.out.println(sb1.toString());
    }
}
