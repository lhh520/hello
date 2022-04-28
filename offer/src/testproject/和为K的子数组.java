package testproject;

import org.junit.Test;

public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int len=nums.length;
        int count=0;
        for(int left=0;left<len;left++){
            for(int right=left;right<len;right++){
                int sum=0;
                for(int i=left;i<=right;i++){
                    sum+=nums[i];
                }
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        System.out.println(subarraySum(nums,3));
    }
}
