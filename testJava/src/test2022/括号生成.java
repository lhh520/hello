package test2022;
import org.junit.Test;

import java.util.*;
public class 括号生成 {
    List<String>list=new ArrayList<>();
    int _n=0;
    public List<String> generateParenthesis(int n) {
        _n=n;
        backtrace(0,0,new StringBuilder());
        return list;
    }
    public void backtrace(int left,int right,StringBuilder sb){
        if(left==right&&left==_n){
            list.add(sb.toString());
            return;
        }
        if(left<_n){
            sb.append('(');
            backtrace(left+1,right,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            backtrace(left,right+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        List<String>list=generateParenthesis(3);
        System.out.println(list);
    }
}
