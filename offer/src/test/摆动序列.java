package test;

import org.junit.Test;

public class 摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        int curDiff=0;
        int preDiff=0;
        int count=1;
        for(int i=0;i<nums.length-1;i++){
            curDiff=nums[i+1]-nums[i];
            if((curDiff<0&&preDiff>=0)||(curDiff>0&&preDiff<=0)){
                count++;
                preDiff=curDiff;
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));
    }
}
