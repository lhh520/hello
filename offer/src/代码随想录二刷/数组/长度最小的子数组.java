package 代码随想录二刷.数组;

import org.junit.Test;

import java.util.Arrays;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums){
        //滑动窗口
        int sum1= Arrays.stream(nums).sum();
        if(sum1<target){
            return 0;
        }
        int l=0,r=1,sum=nums[0];
        int res=Integer.MAX_VALUE;
        while (r<nums.length){
            sum+=nums[r];
            while (sum>=target){
                res=Math.min(res,r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
}
