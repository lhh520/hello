import org.junit.Test;

import java.util.*;

public class test47 {
    List<List<Integer>>ans=new ArrayList<>();
    List<Integer>temp=new ArrayList<>();
    Set<List<Integer>>set=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //
        for(int i=0;i<nums.length;i++)
        {
            temp.add(nums[i]);
        }
        dfs(0,ans,temp,nums);
    return ans;
    }

    public void dfs(int index,List<List<Integer>>ans,List<Integer>temp,int[] nums)
    {
        if(index==nums.length&&set.add(new ArrayList<>(temp)))
        {
            ans.add(new ArrayList<>(temp));
        }
        for(int i=index;i<nums.length;i++)
        {

            Collections.swap(temp,i,index);
            dfs(index+1,ans,temp,nums);

            Collections.swap(temp,i,index);
        }

    }
    @Test
    public void test()
    {
        int[] tt=new int[]{1,1,2};
        System.out.println(permuteUnique(tt));
    }
}
