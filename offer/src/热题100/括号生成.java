package 热题100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        dfs("",n,n,res);
        return res;
    }
    public void dfs(String curStr,int left,int right,List<String>res){
        if(left==0&&right==0){
            res.add(curStr);
            return;
        }
        //剩余左括号大于右括号，不能继续生成
        if(left>right){
            return;
        }
        //
        if(left>0){
            dfs(curStr+"(",left-1,right,res);
        }
        if(right>0){
            dfs(curStr+")",left,right-1,res);
        }
    }
    @Test
    public void test(){
        List<String>list=generateParenthesis(3);
        System.out.println(list.toString());
    }
}
