package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class offer119 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int length=Integer.MIN_VALUE;
        for (int j = 0; j <nums.length-2;)
        {
            int len=0;
            int i=j;
            while (nums[i]==nums[i+1]-1)
            {
                i++;
                len++;
            }
            length=Math.max(len,length);
            j=i+1;
        }
        return length+1;
    }
    public int longestConsecutive1(int[] nums)
    {
        Set<Integer>num_set=new HashSet<>();
        for(int num:nums)
        {
            num_set.add(num);
        }
        int longgstStack=0;
        for(int num:num_set)
        {
            if(!num_set.contains(num-1))
            {
                int currentNum=num;
                int currentStreak=1;
                while (num_set.contains(currentNum+1))
                {
                    currentNum+=1;//修改当前值
                    currentStreak+=1;//增加符合条件的长度
                }
                longgstStack=Math.max(currentStreak,longgstStack);
            }
        }
        return longgstStack;
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive1(nums));
    }
}
