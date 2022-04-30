package testproject;

import org.junit.Test;

public class 最小差值 {
    public int smallestRangeI(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(max,nums[i]);
        }
        if(max-min<=2*k){
            return 0;
        }else {
            return max-min-2*k;
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1};
        System.out.println(smallestRangeI(nums,0));
    }
}
