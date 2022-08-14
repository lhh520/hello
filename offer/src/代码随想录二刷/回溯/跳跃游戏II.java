package 代码随想录二刷.回溯;

import org.junit.Test;

import java.util.Arrays;

public class 跳跃游戏II {
    public int jump(int[]nums){
        int[]can=new int[nums.length];
        Arrays.fill(can,Integer.MAX_VALUE);
        can[0]=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(can[j]!=Integer.MAX_VALUE&&nums[j]>=(i-j)){
                    can[i]=Math.min(can[j]+1,can[i]);
                }
            }
        }
        return can[nums.length-1];
    }
    @Test
    public void test(){
        //nums = [2,3,1,1,4]
        int[]nums=new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
