package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 划分为k个相等的子集 {
    int[]bucket;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        System.out.println(sum);
        if(sum%k!=0){
            return false;
        }
        Arrays.sort(nums);
        int target=sum/k;
        System.out.println(target);
        bucket=new int[k];
        return backtrace(nums,0,k,target);
    }
    public boolean backtrace(int[]nums,int index,int k,int target){
        if(index==nums.length){
            return true;
        }
        for(int i=0;i<k;i++){
            //放入球大于target
            if(bucket[i]+nums[index]>target) continue;
            if(i>0&&bucket[i]==bucket[i-1]){
                continue;
            }
            bucket[i]+=nums[index];
            //处理下一个球
            if(backtrace(nums,index+1,k,target))
                return true;
            bucket[i]-=nums[index];
        }
        return false;
    }
    @Test
    public void test(){
       int[]nums=new int[]{1,1,1,1,2,2,2,2};
        System.out.println(canPartitionKSubsets(nums,2));
    }
}
