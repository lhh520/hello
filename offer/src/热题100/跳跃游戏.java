package 热题100;

import org.junit.Test;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int coverRange=0;
        for(int i=0;i<=coverRange;i++){
            coverRange=Math.max(coverRange,i+nums[i]);
            if(coverRange>=nums.length-1){
                return true;
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
