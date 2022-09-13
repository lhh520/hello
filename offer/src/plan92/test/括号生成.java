package plan92.test;
import org.junit.Test;

import java.util.*;
public class 括号生成 {
    List<String>list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n){
        backtrace(0,0,n);
        return list;
    }
    public void backtrace(int left,int right,int total){
        if(left==right&&left==total){
            list.add(sb.toString());
            return;
        }
        if(left<total){
            sb.append('(');
            backtrace(left+1,right,total);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            backtrace(left,right+1,total);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        List<String>list=generateParenthesis(3);
        System.out.println(list);
    }
}
