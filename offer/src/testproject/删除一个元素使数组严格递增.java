package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 删除一个元素使数组严格递增 {
    public boolean canBeIncreasing(int[] nums) {
        int de=-1;
        int[]newnn1= Arrays.copyOfRange(nums,1,nums.length);
        int[]newnn2= Arrays.copyOfRange(nums,0,nums.length-1);
        boolean flag=false;
        for(int i=0;i<newnn1.length-1;i++){
            if(newnn1[i+1]<=newnn1[i]||newnn2[i+1]<=newnn2[i]){
                flag=true;
            }
        }
        System.out.println(1);
        if(!flag){
            return true;
        }
        int index=-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                index=i;
                break;
            }
        }
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(index!=i){
                list.add(nums[i]);
            }
        }
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public boolean canBeIncreasing1(int[] nums){
        int flag=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                if(flag!=0) return false;
                if(i+1<nums.length){
                    if(nums[i+1]>nums[i-1]||i>=2&&nums[i]>nums[i-2]||i==1){
                        flag=1;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,1,1};
        System.out.println(canBeIncreasing1(nums));
    }
}
