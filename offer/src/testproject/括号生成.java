package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    List<String>ans=new ArrayList<>();
    //StringBuffer sb=new StringBuffer();
    public List<String> generateParenthesis(int n) {
        backtrace(0,0,n,new StringBuffer());
        return ans;
    }
    public void backtrace(int open,int closed,int max,StringBuffer sb1){
        if(sb1.length()==max*2){
            //StringBuffer sb1=new StringBuffer(sb);
            ans.add(sb1.toString());
            return;
        }
        if(open<max){
            sb1.append('(');
            backtrace(open+1,closed,max,sb1);
            sb1.deleteCharAt(sb1.length()-1);
        }
        if(closed<open){
            sb1.append(')');
            backtrace(open,closed+1,max,sb1);
            sb1.deleteCharAt(sb1.length()-1);
        }
    }
    @Test
    public void test(){
        List<String>list=generateParenthesis(3);
        System.out.println(list.toString());
    }
}
