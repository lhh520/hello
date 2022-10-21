package test2022;

import java.util.Stack;

public class 去除重复的字母2 {
    public String removeDuplicateLetters(String s) {
        int[]last=new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        Stack<Character>stack=new Stack<>();
        boolean[]flag=new boolean[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!flag[c-'a']){//表示还未访问
                while (!stack.isEmpty()&&c<stack.peek()&&last[stack.peek()-'a']>i){
                    char cc=stack.pop();
                    flag[cc-'a']=false;
                }
                stack.push(c);
                flag[c-'a']=true;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
