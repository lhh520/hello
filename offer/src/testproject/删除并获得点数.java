package testproject;

import org.junit.Test;

public class 删除并获得点数 {
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length==1){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);//找到最大值
        }
        int[]count=new int[max+1];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int[]dp=new int[max+1];
        dp[1]=count[1]*1;
        dp[2]=Math.max(count[1]*1,count[2]*2);
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+count[i]*i);
        }
        return dp[max];
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,4,2};
        System.out.println(deleteAndEarn(nums));
    }
}
