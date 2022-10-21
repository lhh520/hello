package test2022;
import java.util.*;
public class 去除重复字母 {
    public String removeDuplicateLetters(String s) {
        int[]last=new int[26];
        //记录最后一次的出现的位置
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        Stack<Character>stack=new Stack<>();
        boolean[]flag=new boolean[26];
        for(int i=0;i<s.length();i++){
            char cc=s.charAt(i);
            if(!flag[cc-'a']){//表示还未访问
                while (stack.isEmpty()&&cc<stack.peek()&&last[stack.peek()-'a']>i){
                    char c=stack.pop();
                    flag[c-'a']=false;
                }
                stack.push(cc);
                flag[cc-'a']=true;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
