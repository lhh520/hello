package plan92.test;

import org.junit.Test;

public class 跳跃游戏 {
    public boolean canJump(int[] nums){
        int cover=0;
        for(int i=0;i<=cover;i++){
            cover=Math.max(cover,i+nums[i]);
            if(cover>=nums.length-1){
                return true;
            }
        }
        return false;
    }
    public boolean canJump1(int[] nums){
        int[]canJump=new int[nums.length];
        canJump[0]=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(canJump[j]==1&&nums[j]>=(i-j)){
                    canJump[i]=1;
                    break;
                }
            }
        }
        return canJump[nums.length-1]==1;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
