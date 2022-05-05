package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int[]newnums=nums.clone();
        Arrays.sort(nums);
        int m=0,n=nums.length-1;
        if(Arrays.equals(nums,newnums))
            return 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=newnums[i]){
                 m=i;
                 break;
            }
        }

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]!=newnums[i]){
                n=i;
                break;
            }
        }
        return n-m+1;
    }
    public int findUnsortedSubarray1(int[] nums){
        int []copy=nums.clone();
        Arrays.sort(nums);
        int i=0,j=0;
        for(i=0;i<nums.length;i++){
            if(copy[i]!=nums[i]){
                break;
            }
        }
        //
        for(j=nums.length-1;j>=0;j--){
            if(copy[j]!=nums[j]){
                break;
            }
        }
        return j-i+1;
    }




    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,4};
        System.out.println(findUnsortedSubarray1(nums));
    }
}
