package hot100;

public class 跳跃游戏 {
    public boolean canJump(int[] nums){
        if(nums.length==1){
            return true;
        }
        int coverRange=0;
        for(int i=0;i<coverRange;i++){
            coverRange=Math.max(coverRange,i+nums[i]);
            if(coverRange>=nums.length){
                return true;
            }
        }
        return false;
    }
    //
    public boolean canJump1(int[] nums){
        int[]canJump=new int[nums.length];
        canJump[0]=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(canJump[j]==1&&nums[j]>=(j-i)){
                    canJump[i]=1;
                    break;
                }
            }
        }
        return canJump[nums.length-1]==1;
    }
}
