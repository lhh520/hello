package offer;

import org.junit.Test;

import java.util.*;

public class offer081 {
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>conbine=new ArrayList<>();
        dfs(candidates,ans,conbine,0,target);
        return ans;
    }
    public  void dfs(int[] candidates,List<List<Integer>>ans,List<Integer>conbine,int index,int target)
    {   //已经遍历到最后，仍不满足条件，应该返回
        if(index==candidates.length)
            return;
        //当前的可以满足条件，则应该加入到数组中，并且返回，不返回可能会有重复
        if(target==0)
        {
            ans.add(new ArrayList<>(conbine));
            return;
        }
        //不选择当前的数字
        dfs(candidates,ans,conbine,index+1,target);
        //可以选择当前的额数字
        if(target>=candidates[index])
        {   //先将当前的数字加入
            conbine.add(candidates[index]);
            //进行遍历，此时剩下的目标值就是target减去当前值
            dfs(candidates,ans,conbine,index,target-candidates[index]);
            //将加入的数字移除，进行回溯
            conbine.remove(conbine.size()-1);
        }
    }
    @Test
    public void test()
    {

    }
}
