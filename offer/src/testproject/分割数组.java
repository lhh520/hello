package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 分割数组 {
    public int partitionDisjoint(int[] nums) {
        int max=nums[0];
        int[]helper1=new int[nums.length];
        int[]helper2=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            helper1[i]=max;
        }
        //System.out.println(Arrays.toString(helper1));
        max=nums[nums.length-1];
        for(int i=nums.length-1;i>=0;i--){
            max=Math.min(max,nums[i]);
            helper2[i]=max;
        }
        for(int i=1;i<nums.length;i++){
            if(helper1[i-1]<=helper2[i]){
                return i;
            }
        }
        return 0;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,1,1,0,6,12};
        System.out.println(partitionDisjoint(nums));
    }
}
