import org.junit.Test;

import java.util.Arrays;

public class testpaixu {
    @Test
    public void test1()//选择排序
    {
        int[] nums=new int[]{1,4,3,5,2};
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[j]<nums[i])
                {
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    //冒泡排序
    @Test
    public void test2()
    {
        int[] nums=new int[]{1,4,3,5,2};
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length-1-i;j++)
            {
                if(nums[j+1]<nums[j])
                {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    //快速排序
    @Test
    public void test3()
    {
        int[] nums=new int[]{1,4,3,5,2};
        dfs(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    void dfs(int[] nums,int begin,int end)
    {
        if(begin>end)//左右指针相碰。则返回
            return;
        int temp=nums[begin];//交换的中间值
        int i=begin;
        int j=end;
        while(i!=j)
        {
            while (nums[j]>=temp&&j>i)//已经满足排序条件的,则右指针左移
                j--;
            while (nums[i]<=temp&&j>i)//已经满足排序条件，左指针右移动
                i++;
            //想下说明已经开始满足交换条件，及nums[i]>temp,且nums[j]<temp
            if(j>i)//满足交换条件
            {
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
        }
        //交换完成之后，开始进行分治
        nums[begin]=nums[i];//更换新的中间值
        nums[i]=temp;//i和j重合的位置，就是下一次排序的中间值
        dfs(nums,begin,i-1);//左边一半
        dfs(nums,i+1,end);//右边一半
    }
}
