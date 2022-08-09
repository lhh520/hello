package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 检查数组是否存在有效划分 {
    //dfs
    public boolean validPartition(int[] nums) {
         return isValid(nums,0,nums.length-1);
    }
    boolean isValid(int[]nums,int i,int j){
        if(i==j){
            return false;
        }
        if(j-i==1){
            if(nums[i]==nums[j]){
                return true;
            }else {
                return false;
            }
        }
        if(j-i==2){
            if((nums[i]==nums[i+1]&&nums[i]==nums[i+2])||(nums[i+1]==nums[i]+1&&nums[i+2]==nums[i+1]+1)){
                return true;
            }else {
                return false;
            }
        }
        return (isValid(nums,i,i+1)&&isValid(nums,i+2,j))||(isValid(nums,i,i+2)&&isValid(nums,i+3,j));
    }
    //动态规划
    public boolean validPartition1(int[] nums){
        int n=nums.length;
        boolean[]dp=new boolean[n+1];
        dp[0]=true;
        dp[1]=false;
        for(int i=2;i<=n;i++){
            dp[i]=false;
            if(nums[i-1]==nums[i-2]&&dp[i-2]){
                dp[i]=true;
            }
            if(i>=3&&nums[i-1]==nums[i-2]&&nums[i-1]==nums[i-3]&&dp[i-3]){
                dp[i]=true;
            }
            if(i>=3&&nums[i-1]-1==nums[i-2]&&nums[i-2]-1==nums[i-3]&&dp[i-3]){
                dp[i]=true;
            }
        }
        return dp[n];
    }
    //

    @Test
    public void test(){
        int[]nums=new int[]{1,1,1,2};
        System.out.println(validPartition(nums));
    }
}

