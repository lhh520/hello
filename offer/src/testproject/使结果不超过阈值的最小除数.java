package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 使结果不超过阈值的最小除数 {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1,r=Arrays.stream(nums).max().getAsInt();
        int ans=0;
        while (l<=r){
            int mid=(l+r)/2;//求得最小值
            int sum=0;
            for(int i=0;i< nums.length;i++){
                //sum+=(nums[i]/mid==0?nums[i]/mid:nums[i]/mid+1);
                sum+=(nums[i]-1)/mid+1;
            }
            if(sum<=threshold){
                ans=mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums =new int[]{1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums,6));
    }
}
