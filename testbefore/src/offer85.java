import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class offer85 {
    List<String>ans=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs1(0,0,n);
        return ans;
    }
    public  void dfs(int l,int r,int n)//l表示左括号数，r 表示右括号数，n表示题目要求的括号数
    {
        if(r>l||l>n||r>n)//右括号大于左括号，左右括号大于要求的括号数
            return;
        if(l==r&&r==n)//满足条件，可以结束本轮递归
        {
            ans.add(sb.toString());
            return;
        }
        //尝试添加左括号
        sb.append('(');//添加左括号
        dfs(l+1,r,n);//添加一个左括号，进入遍历
        sb.deleteCharAt(sb.length()-1);
        //尝试添加右括号
        sb.append(')');
        dfs(l,r+1,n);
        sb.deleteCharAt(sb.length()-1);
    }
    @Test
    public void test()
    {
        List<String>ans=generateParenthesis(3);
        System.out.println(ans.toString());
    }
    public  void dfs1(int l,int r,int n)
    {
        //1.声明离开递归的条件:右括号大于左括号或者左括号，右括号大于n
        if(r>l||r>n||l>n)
        {
            return;
        }
        //2.声明满足条件，可以添加到结果情况:左右括号相等，等于括号对数n
        if(r==l&&r==n)
        {
            ans.add(sb.toString());
            return;
        }
        //3.左括号添加的情况,添加之后，进入递归
        sb.append('(');
        dfs1(l+1,r,n);
        sb.deleteCharAt(sb.length()-1);
        //4.右括号添加的情况，添加之后，进入递归
        sb.append(')');
        dfs1(l,r+1,n);
        sb.deleteCharAt(sb.length()-1);
    }
}
