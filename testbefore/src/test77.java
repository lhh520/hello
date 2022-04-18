import java.util.ArrayList;
import java.util.List;

public class test77 {
    List<List<Integer>>ans=new ArrayList<>();
    List<Integer>temp=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        dfs(1,n,k);
        return ans;
    }
    public void dfs(int cur,int n,int k)
    {   //要取得长度为k的序列，则没有使用的长度不能小于k
        if(temp.size()+(n-cur+1)<k)
            return;
        //有效答案的记录
        if(temp.size()==k)
        {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        //考虑当前位置
        temp.add(cur);
        dfs(cur+1,n,k);
        //回溯方法，将当前的数字去除
        temp.remove(temp.size()-1);
        //考虑不选择当前的数字
        dfs(cur+1,n,k);
    }
}
