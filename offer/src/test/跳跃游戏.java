package test;

import org.junit.Test;

public class 跳跃游戏 {
    public boolean canJump(int[] nums){
        if(nums.length==1){
            return true;
        }
        int n=nums.length;
        System.out.println(1);
        int coverRange=0;
        for(int i=0;i<coverRange;i++){
            coverRange=Math.max(coverRange,i+nums[i]);//这是可以跳跃的最远的距离
            if(coverRange>=nums.length-1){
                return true;
            }
        }
        return false;
    }
    //
    public boolean canJump1(int[] nums,int k){
        int cnt=0,n=nums.length;
        int coverRange=0;
        int range=0;
        for(int i=0;i<coverRange;i++){
            coverRange=Math.max(coverRange,i+nums[i]);//这是可以跳跃的最远的距离
            if(coverRange>=nums.length-1){
                if(cnt+1<=k){
                    return true;
                }else {
                    return false;
                }

            }
            if(i==range){//表明下一个的位置
                cnt++;
                range=coverRange;//下一跳的位置
            }
        }
        return false;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
