package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 摆动序列 {
    public void wiggleSort(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int[]bucket=new int[max+1];
        for(int i=0;i<nums.length;i++){
            bucket[nums[i]]++;
        }
        int n=nums.length;
        int k=max;
        for(int i=1;i<nums.length;i=i+2){
            while (bucket[k]==0){
                k--;
            }
            nums[i]=k;
            bucket[k]--;
        }
        for(int i=0;i<nums.length;i=i+2){
            while (bucket[k]==0){
                k--;
            }
            nums[i]=k;
            bucket[k]--;
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,5,1,1,6,4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
