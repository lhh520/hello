package plan92;
import org.junit.Test;

import java.util.*;
public class 括号生成 {
    List<String>list=new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n){
        this.n=n;
        backtrace(new StringBuilder(),0,0);
        return list;
    }
    public void backtrace(StringBuilder sb,int left,int right){
        if(sb.length()==2*n&&left==right&&left==n){
            list.add(sb.toString());
            return;
        }
        if(right<left){
            sb.append(')');
            backtrace(sb,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(left<n){
            sb.append('(');
            backtrace(sb,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }


    }
    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
