package 新刷题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    List<String>list=new ArrayList<>();
    int _n=0;
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        _n=n;
        backtrance(0,0);
        return list;
    }
    public void backtrance(int left,int right){
        if(left==right&&left==_n){
            list.add(sb.toString());
            return;
        }
        if(left<_n){
            sb.append('(');
            backtrance(left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            backtrance(left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
