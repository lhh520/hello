package back;

import java.util.Arrays;

public class 跳跃游戏II {
    public int jump(int[]nums){
        int[]can=new int[nums.length];
        Arrays.fill(can,Integer.MAX_VALUE);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(can[j]!=Integer.MAX_VALUE&&nums[j]>=(i-j)){
                    can[i]=Math.min(can[j]+1,can[i]);
                }
            }
        }
        return can[nums.length-1];
    }
}
