package face;
import org.junit.Test;

import java.util.*;
public class 括号生成 {
    int n;
    List<String>list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        this.n=n;
        backtrace(new StringBuilder(),0,0);
        return list;
    }
    public void backtrace(StringBuilder sb,int left,int right){
        if(left==right&&right==n){
            list.add(sb.toString());
            return;
        }
        if(left<n){//左括号小于总数 可以一直添加左括号
            sb.append('(');
            backtrace(sb,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            backtrace(sb,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test(){
        List<String>list=generateParenthesis(3);
        System.out.println(list);
    }
}
