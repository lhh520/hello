package 代码随想录二刷.回溯;

public class 跳跃游戏 {
    public boolean canJump(int[] nums){
        //每次应该从当前能跳的最大值中找
        if(nums.length==1){
            return true;
        }
        int coverRange=0;
        for(int i=0;i<=coverRange;i++){
            coverRange=Math.max(i+nums[i],coverRange);
            if(coverRange>=nums.length-1){
                return true;
            }
        }
        return false;
    }
    //
    public boolean canJump1(int[] nums){
        int[]can=new int[nums.length];
        can[0]=1;
        for(int i=1;i< nums.length;i++){
            for(int j=0;j<i;j++){
                if(can[j]==1&&nums[j]>=(i-j)){
                    can[i]=1;
                    break;
                }
            }
        }
        return can[nums.length-1]==1;
    }
}
