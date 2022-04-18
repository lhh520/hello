import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class offer083
{
    public List<List<Integer>> permute(int[] nums) {
        //设置保存最终结果和中间结果的两个数组
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        //先将所有的数字全部放入进去
        for(int num:nums)
        {
            temp.add(num);
        }
        int n=nums.length;

        dfs(n,ans,temp,0);
        return ans;
    }
    public void dfs(int n,List<List<Integer>>ans,List<Integer>temp,int index)
    {  //如果
       if(index==n)
           ans.add(new ArrayList<>(temp));
       for(int i=index;i<n;i++)
       {   //交换index和后面的数字，交换之后，遍历，然后再回溯函数
           Collections.swap(temp,index,i);
           dfs(n,ans,temp,index+1);
           Collections.swap(temp,index,i);
       }
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{1,2,3};
        List<List<Integer>>ans=permute(nums);
        System.out.println(ans);
    }
}
