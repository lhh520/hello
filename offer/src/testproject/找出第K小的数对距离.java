package testproject;

import org.junit.Test;

import java.util.*;

public class 找出第K小的数对距离 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length,left=0,right=nums[n-1]-nums[0];
        while (left<right){
            int mid=(left+right)/2;
            int cnt=0;
            for(int i=0,j=0;j<n;j++){
                while (nums[j]-nums[i]>mid){
                    i++;
                }
                cnt+=j-i;
            }
            if(cnt>=k){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
    @Test
    public void test(){
        int[] nums=new int[]{1,3,1};
        int k=1;
        System.out.println(smallestDistancePair(nums,k));
    }
}
