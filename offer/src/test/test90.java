package test;

import org.junit.Test;

import java.util.*;

public class test90 {
    Set<List<Integer>>set=new HashSet<>();
    List<List<Integer>>ans=new ArrayList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
     dfs(nums,0);
     return ans;
    }
    public void dfs(int[]nums,int index)
    {   if(set.add(new ArrayList<>(temp)))
        ans.add(new ArrayList<>(temp));
        if(index>=nums.length)
        {
            return;
        }
        for(int i=index;i<nums.length;i++)
        {   if(i>0&&nums[i]==nums[i-1])
            continue;
            temp.add(nums[i]);
            dfs(nums,index+1);
            temp.removeLast();
        }

    }
    @Test
    public void test()
    {
        int[] nums=new int[]{1,2,2};
        List<List<Integer>>ans1=subsetsWithDup(nums);
        System.out.println(ans1.toString());
    }
}
