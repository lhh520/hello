package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最少移动次数使数组元素相等II {
    public int minMoves2(int[] nums) {
        //首先进行排序
        Arrays.sort(nums);
        //找到中位数
        int mid;
        if(nums.length%2!=0){
            mid=nums[nums.length/2];
        }else {
            mid=nums[nums.length/2];
        }

        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+Math.abs(nums[i]-mid);
        }
        return sum;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,10,2,9};
        System.out.println(minMoves2(nums));
    }
}
