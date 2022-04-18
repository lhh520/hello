import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test78 {
    List<List<Integer>>ans=new ArrayList<List<Integer>>();

    List<Integer>temp=new ArrayList<Integer>();


    public List<List<Integer>> subsets(int[] nums) {
        int len=nums.length;
        ans.add(new ArrayList<>(temp));
    dfs(0,temp,ans,len,nums);
    return ans;
    }
    public void dfs(int index,List<Integer>temp,List<List<Integer>>ans,int len,int[] nums)
    {
        if(index==len)
        {
            //ans.add(new ArrayList<>(temp));
         return;
        }
        for(int i=index;i<len;i++)
        {
            temp.add(nums[i]);
        ans.add(new ArrayList<>(temp));
        dfs(i+1,temp,ans,len,nums);
        temp.remove(temp.size()-1);
        }
    }
    @Test
    public void test()
    {
        //nums = [1,2,3]
        int[] nums=new int[]{1,2,3};
        List<List<Integer>>tt=subsets(nums);
        System.out.println(tt);
    }
}
