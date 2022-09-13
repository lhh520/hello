package plan92.test;

import java.util.Arrays;

public class 下一个排列 {
    public void nextPermutation(int[] nums){
        //从后向前 找到第一个降序
        int next1=0;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i-1]<nums[i]){
                next1=i-1;
                break;
            }
        }
        int next2=next1;
        int min=Integer.MAX_VALUE;

        for(int i=next1+1;i< nums.length;i++){
            int temp=nums[i]-nums[next1];
            if(temp>0&&temp<min){
                min=temp;
                next2=i;
            }
        }
        if(next1==next2){
            Arrays.sort(nums);
            return;
        }
        int temp=nums[next1];
        nums[next1]=nums[next2];
        nums[next2]=temp;
        Arrays.sort(nums,next1+1,nums.length);
    }
}
