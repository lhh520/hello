package baidu;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class test03 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        Scanner sc=new Scanner(System.in);
        String next=sc.nextLine();
        int i=0;
        while (i==0||(next!=null&&!next.equals(""))){
            String ss=next;
            if(ss.equals("")){
                i++;
            }
            next=sc.nextLine();
            sb.append(ss);
            if(i!=0&&(next!=null&&!next.equals(""))){
                break;
            }
        }
        Stack<Character>stack=new Stack<>();
        int max=0;
        System.out.println(sb);
        for(int j=0;j<sb.length();j++){
            if(sb.charAt(j)=='{'){
                stack.push('{');
            }
            System.out.println(stack.size());
            max=Math.max(max,stack.size()-2);
            if(sb.charAt(j)=='}'){
                stack.pop();
            }
        }
        System.out.println(max);
    }
}
