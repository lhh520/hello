package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 非递减数列 {
    public boolean checkPossibility(int[] nums) {
        int n= nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                if(dp[i]>=3){
                    return false;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return true;
    }
    public boolean checkPossibility1(int[] nums){
        for(int i=0;i< nums.length-1;i++){
            int x=nums[i],y=nums[i+1];
            if(x>y){
                nums[i]=y;//将前面的数字修改
                if(sorted(nums)){
                    return true;//表示修改过之后 直接可以返回正确的值
                }
                nums[i]=x;
                nums[i+1]=x;
                return sorted(nums);
            }
        }
        return true;
    }
    public boolean sorted(int[]nums){
        for(int i=1;i< nums.length;i++){
            if(nums[i-1]>nums[i]){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,2,1};
        System.out.println(checkPossibility1(nums));
    }
}
