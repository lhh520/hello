import java.util.*;

public class offer82 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len=candidates.length;
        //List<List<>>
        //结果存储
        List<List<Integer>>ans=new ArrayList<>();
        if(len==0)
            return ans;
        Arrays.sort(candidates);
        //队列添加路径
        Deque<Integer>path=new ArrayDeque<>(len);
        //
        dfs(candidates,len,0,target,path,ans);
        return ans;
    }
    public void dfs(int[] candidates,int len,int begin,int target,Deque<Integer>path,List<List<Integer>>ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        //从第一个到最后一个，左右遍历
        for(int i=begin;i<len;i++)
        {   //如果目标值小于当前窗口的最小值，直接退出循环
            if(target-candidates[i]<0)
                break;
            //排序中的数字重复，则减少运算
            if(i>begin&&candidates[i]==candidates[i-1])
                continue;
            //将当前的数字添加进去
            path.addLast(candidates[i]);
            //窗口向右移动，找到去除当前值的目标值
            dfs(candidates,len,i+1,target-candidates[i],path,ans);
            //回溯，去除最后一位数字
            path.removeLast();
        }


    }
}
