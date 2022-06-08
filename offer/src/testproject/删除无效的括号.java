package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 删除无效的括号 {
    Set<String> set = new HashSet<>();
    String s;
    int max,len;
    int n;
    public List<String> removeInvalidParentheses(String s) {
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
        }
        this.s=s;
        n=s.length();
        max=Math.min(left,right);
        backtrace(0,"",0);//left 表示剩下的左括号 right等于剩下的右括号
        return new ArrayList<>(set);
    }
    public void backtrace(int index,String cur,int score){
        if(score<0||score>max){//表示遍历到了最后
            return;
        }
        if(index==n){
            if(score==0&&cur.length()>=len) {
                if(cur.length()>len)
                    set.clear();
                len=cur.length();
                set.add(cur);
            }
            return;
        }
        char c= s.charAt(index);
        if(c=='('){
            backtrace(index+1,cur+String.valueOf(c),score+1);
            backtrace(index+1,cur,score);
        }else if(c==')'){
            backtrace(index+1,cur+String.valueOf(c),score-1);
            backtrace(index+1,cur,score);
        }else {
            backtrace(index+1,cur+String.valueOf(c),score);
        }
    }
    @Test
    public void test(){
        String s="()())()";
        List<String>list=removeInvalidParentheses(s);
        System.out.println(list.toString());
    }
}
