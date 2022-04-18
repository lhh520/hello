package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test955 {
    public int[] sortArrayByParity(int[] nums) {
        int[]nu=new int[nums.length];
        int[]nu2=new int[nums.length];
        int j=0,k=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                nu[j]=nums[i];
                j++;
            }
            else
            {
                nu2[k]=nums[i];
                k++;
            }
        }
        //
        for(int i=0;i<j;i++)
        {
            nums[i]=nu[i];
        }
        for(int i=0;i<k;i++)
        {
            nums[j+i]=nu2[i];
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
    @Test
    public  void ee() {
        int[]nn=new int[]{3,1,2,4};
        sortArrayByParity(nn);
    }
}
