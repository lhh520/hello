package test;

import org.junit.Test;

import java.util.Arrays;

public class 峰与谷 {
    public void wiggleSort(int[] nums) {
        //将数组进行排序
        int[]nn=nums.clone();
        Arrays.sort(nn);
        int[]ans=new int[nums.length];
        //先排列大的数字
        int j=nums.length-1;
        for(int i=0;i<nums.length;i=i+2){
            nums[i]=nn[j];
            j=j-1;
        }
        //排列小的数字
        for(int i=1;i<nums.length;i=i+2){
            nums[i]=nn[j];
            j=j-1;
        }
        System.out.println(Arrays.toString(nums));

    }
    @Test
    public void test(){
        int[]nums=new int[]{5, 1, 3, 2, 3};
        wiggleSort(nums);
    }
}
