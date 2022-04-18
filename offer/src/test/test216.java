package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class test216 {
    HashSet<String> set=new HashSet<>();
    int[] nums;
    int[] visited;
    List<List<Integer>>ans=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        nums=new int[]{1,2,3,4,5,6,7,8,9};
        visited=new int[9];
        dfs(0,0,n,0,n);
        return ans;
    }
    public void dfs(int index,int len,int target,int cur,int n)
    {
        if(len==n)
        {
            if(cur==target)
                ans.add(new ArrayList<>(list));
            return;
        }
        if(index>=nums.length)
            return;
        for (int i = index; i <nums.length; i++) {
            if(visited[nums[i]-1]==1)
                continue;
            //进行回溯
            visited[nums[i]-1]=1;
            list.add(nums[i]);
            cur=cur+nums[i];
            dfs(i+1,len+1,target,cur,n);
            visited[nums[i]-1]=0;
            list.remove(list.size()-1);
            cur=cur-nums[i];
        }
    }


}
