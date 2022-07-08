package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 括号 {
    List<String>list=new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n=n;
        //dfs("");
        dfs("",0,0,n);
        System.out.println(list.toString());
        return list;
    }
    public void dfs1(String s){
        if(s.length()==n*2){
            list.add(s);
            return;
        }
        dfs1(s+'(');
        dfs1(s+')');
    }
    public void dfs(String s,int left,int right,int n){
        if(left>n||left<right){//已经出现大于n的情况
            return;
        }
        if(s.length()==n*2){
            list.add(s);
            return;
        }
        dfs(s+'(',left+1,right,n);
        dfs(s+')',left,right+1,n);
    }
    @Test
    public void test(){
        List<String>list=generateParenthesis(2);

    }
}
