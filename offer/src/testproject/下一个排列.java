package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int i=len-2;
        int j=len-1;
        int k=len-1;
        //从后往前，找到第一个逆序对
        while(i>0&&nums[i]>nums[j]){
            i--;
            j--;
        }
        //开始寻找需要进行交换的数对
        while (k>j&&nums[k]<nums[i]){
            k--;
        }
//        System.out.println("i "+nums[i]+"j "+nums[j]);
//        System.out.println("k "+nums[k]);
//        System.out.println(i);
//        System.out.println(Arrays.toString(nums));
        int flag=0;
        if(nums[i]<nums[j])
        {int temp=nums[i];
        nums[i]=nums[k];
        nums[k]=temp;
        flag=1;}
        //System.out.println(Arrays.toString(nums));
        //后面的进行进行逆序
        //System.out.println(i);
        if(i==0&&flag==1)
        i=j;
        j=len-1;

        while (i<j){
            int t=nums[j];
            nums[j]=nums[i];
            nums[i]=t;
            i++;
            j--;
        }

        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,2};
        nextPermutation(nums);
    }
}
