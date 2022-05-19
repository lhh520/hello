package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 主要元素 {
    public int majorityElement(int[] nums) {
        int candidate=-1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate=nums[i];
            }
            if(nums[i]==candidate){
                count++;
            }else {
                count--;
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate){
                count++;
            }
        }
        return count*2>nums.length?candidate:-1;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,2,3};
        System.out.println(majorityElement(nums));
    }
}
