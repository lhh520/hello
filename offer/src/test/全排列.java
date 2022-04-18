package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>>全部全排列(int[] nums)
    {
        dfs(nums,0,nums.length-1);
        System.out.println(lists.toString());
        return lists;
    }
    public void dfs(int[] nums,int i,int j)
    {
        if(i==j)
        {
            for(int k=0;k<nums.length;k++)
            {
                list.add(nums[k]);
            }
            lists.add(new ArrayList<>(list));
            list.clear();
        }
        else
        {
            for(int k=i;k<j;k++)
            {
                swap(nums,k,i);
                dfs(nums,i+1,j);
                swap(nums,k,i);
            }
        }
    }
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    //子序列
    public List<List<Integer>>子序列(int[] nums)
    {
        System.out.println(1);
        dfs1(nums,0,list);
        System.out.println(lists.toString());
        return lists;
    }
    public void dfs1(int[] nums,int index,List<Integer>list)
    {
        if(index==nums.length)
        {   //lists.add(new ArrayList<>(list));
            System.out.println(list.toString());
            return;
        }
        lists.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++)
        {
            list.add(nums[i]);
            //lists.add(new ArrayList<>(list));
            dfs1(nums,index+1,list);
            list.remove(list.size()-1);
            //dfs1(nums,index+1,list);
        }



    }
    @Test
    public void test1()
    {
        int[] nums=new int[]{1,2,3,4};
        //List<List<Integer>>lists1=全部全排列(nums);
        List<List<Integer>>lists12=子序列(nums);
    }
}
