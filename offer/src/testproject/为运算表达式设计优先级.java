package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 为运算表达式设计优先级 {
    char[]cs;
    public List<Integer> diffWaysToCompute(String expression) {
        cs=expression.toCharArray();
        return dfs(0,cs.length-1);
    }
    public List<Integer> dfs(int l,int r){
        List<Integer>ans=new ArrayList<>();
        for(int i=l;i<r;i++){
            if(cs[i]>='0'&&cs[i]<='9') continue;//只有运算符会被记录
            List<Integer>l1=dfs(l,i-1);
            List<Integer>l2=dfs(i+1,r);
            for(int a:l1){
                for(int b:l2){
                    int cur=0;
                    if(cs[i]=='+') cur=a+b;
                    else if(cs[i]=='-') cur=a-b;
                    else cur=a*b;
                    ans.add(cur);
                }
            }
        }
        if(ans.isEmpty()){
            int cur=0;
            for(int i=l;i<=r;i++){
                cur=cur*10+(cs[i]-'0');
            }
            ans.add(cur);
        }
        return ans;
    }
    @Test
    public void test(){
        String expression = "2*3-4*5";
        List<Integer>list=diffWaysToCompute(expression);
        System.out.println(list.toString());
    }
}
