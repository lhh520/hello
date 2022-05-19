package testproject;

import org.junit.Test;

public class 最小操作次数使数组元素相等 {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+(nums[i]-min);
        }
        return sum;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        System.out.println(minMoves(nums));
    }
}
